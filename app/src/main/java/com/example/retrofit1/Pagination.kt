package com.example.retrofit1

data class Pagination(
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)