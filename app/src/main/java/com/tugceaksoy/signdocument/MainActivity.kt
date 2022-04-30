package com.tugceaksoy.signdocument

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CallRetrofit()

    }

    private fun CallRetrofit() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://httpbin.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val signatureApi: SignatureApi = retrofit.create(SignatureApi::class.java)

        val post1 = LoginRequestModel("tugce@tugce.com", "strongpassword")

        val call: Call<LoginResponseModel>
        call = signatureApi.PostDataIntoServer(post1,"tugce")
        call.enqueue(object : Callback<LoginResponseModel> {
            override fun onResponse(
                call: Call<LoginResponseModel>,
                response: Response<LoginResponseModel>
            ) {
            }

            override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
            }

        })


    }
}