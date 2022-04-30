package com.tugceaksoy.signdocument

import retrofit2.http.Body
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.POST




public interface SignatureApi {
    @POST("post")
    fun   PostDataIntoServer(@Body signatureModel: LoginRequestModel, @Header("Signature") signature: String):Call<LoginResponseModel>






}