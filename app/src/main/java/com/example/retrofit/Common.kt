package com.example.retrofit


object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitServices : RetrofitServices
        get() {
           return RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
        }

    // get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}