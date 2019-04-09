package tech.wd.com.kwsciencad

import android.content.Context
import com.kotlinframework.net.network.IModelCallback

interface LoginContract {
    interface iLoginPresenter{
        fun login(hashMap: HashMap<String, String>,context: Context)
    }
    interface iLoginModel{
        fun setLogins(context: Context,hashMap: HashMap<String,String>,modelCallback: IModelCallback<LoginBean>)
    }
    interface iLoginView{
        fun LoginSuccess(loginBean: LoginBean)
        fun LoginFailure(string: String)
    }
}