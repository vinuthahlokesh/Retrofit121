package com.example.retrofit1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(val list: List<DataX>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    // private lateinit var  data : List<DataClass>
    // RecyclerAdapter( data:List<DataClass>){
    //     this.data = data
    //}

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtview_id = itemView.findViewById<TextView>(R.id.textview)
       //val txtview_name = itemView.findViewById<TextView>(R.id.txtname)
        //val txtview_email = itemView.findViewById<TextView>(R.id.txtemail)
        //val txtview_status = itemView.findViewById<TextView>(R.id.txtstatus)
       // val txtview_created = itemView.findViewById<TextView>(R.id.txtcreated)
       // val txtview_updated = itemView.findViewById<TextView>(R.id.txtupdated)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.textview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtview_id.text = getdata(position)
      //  holder.txtview_name.text = list[position].toString()
        // holder.txtview_email.text = list[position].toString()
       // holder.txtview_status.text = list[position].toString()
       // holder.txtview_created.text = list[position].toString()
       // holder.txtview_updated.text = list[position].toString()
    }

    override fun getItemCount(): Int = list.size
    fun getdata(position: Int):String{
        val data = StringBuilder(

          "id= ${ list[position].id }\n" +
                  "body=${list[position].body}\n"+"createdat=${list[position].created_at}\n"+"updatedat=${list[position].updated_at}\n"+
                  "userid=${list[position].user_id}\n"+"title=${list[position].title}"
        )
      return data.toString()
    }
}