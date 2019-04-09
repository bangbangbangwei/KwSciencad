package tech.wd.com.kwsciencad

import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiService {
    @POST
    @FormUrlEncoded
    fun login(@Url url:String,@FieldMap hashmap: HashMap<String,String>): Observable<LoginBean>
}