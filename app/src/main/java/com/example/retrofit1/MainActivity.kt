package com.example.retrofit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var data: Data


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retro = RetrofitObject.getRetrofitInstance()
        val apiInterface = retro.create(RetrofitInterface::class.java)
        val objects: Call<Data> = apiInterface.getdata()

        objects.enqueue(
            object : Callback<Data> {
                override fun onResponse(
                    call: Call<Data>,
                    response: Response<Data>
                ) {
                    val dataList: Data = response.body()
                   val something : List<DataX> = dataList.data

                    recyclerView.adapter = RecyclerAdapter(something)
                }
                override fun onFailure(call: Call<Data>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_LONG).show()
                }
            })

    }
}