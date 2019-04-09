package tech.wd.com.kwsciencad

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetUtils private constructor(){
    lateinit var retrofit: Retrofit
    companion object {
        val instant: NetUtils by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED){
            NetUtils()
        }
    }
    fun init(string: String){
        val okHttpClient = OkHttpClient
                .Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                        if (BuildConfig.DEBUG){HttpLoggingInterceptor.Level.BODY}
                        else{HttpLoggingInterceptor.Level.NONE}
                ))
                .connectTimeout(5000,TimeUnit.SECONDS)
                .readTimeout(5000,TimeUnit.SECONDS)
                .writeTimeout(5000,TimeUnit.SECONDS)
                .build()
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(string)
                .client(okHttpClient)
                .build()
    }
}