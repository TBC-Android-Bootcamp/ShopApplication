package com.gvelesiani.shopapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("{user}")
    fun listRepos(@Path("user") user: String?): Call<String>?
}