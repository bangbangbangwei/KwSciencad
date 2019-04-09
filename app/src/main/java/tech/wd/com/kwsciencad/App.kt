package tech.wd.com.kwsciencad

import android.app.Application
import com.kotlinframework.net.network.RetrofitManager

class App: Application(){
    override fun onCreate() {
        super.onCreate()
        RetrofitManager.instance.init(UserApi.BASE_API)
    }
}