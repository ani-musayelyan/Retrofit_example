package JsonExample

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("/photos")
    fun getJson() : Call<MutableList<Photo>>

    companion object {
        private val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

//        private var retrofit: Retrofit? = null
//        fun getClient(): Retrofit {
//            if (retrofit == null) {
//                retrofit = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            }
//            return retrofit!!
//        }

    
}