package com.tugceaksoy.signdocument


import android.util.Base64
import java.nio.charset.StandardCharsets
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec



class SignDocument() {
    private var generatedPassword: String? = null

    fun encryptSHA256(SHARED_SECRET:String, REQUEST_METHOD:String, REQUEST_PATH:String, REQUEST_BODY:String): String? {

        val  hashData = "$SHARED_SECRET-$REQUEST_METHOD-$REQUEST_PATH-$REQUEST_BODY"

     try {
        val mac = Mac.getInstance("HmacSHA256")
        val secretKeySpec = SecretKeySpec(SHARED_SECRET.toByteArray(StandardCharsets.UTF_8), "HmacSHA256")
        mac.init(secretKeySpec)
        val macData = mac.doFinal(hashData.toByteArray(StandardCharsets.UTF_8))
        generatedPassword = Base64.encodeToString(macData,Base64.URL_SAFE)

     } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
     } catch (e: InvalidKeyException) {
        e.printStackTrace()
     }


return generatedPassword
}
}


