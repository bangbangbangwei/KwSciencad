package tech.wd.com.kwsciencad

import android.content.Context
import com.kotlinframework.net.network.IModelCallback

class LoginPresentre:LoginContract.iLoginPresenter {
    lateinit var loginModel: LoginModel
    lateinit var iLoginView: LoginContract.iLoginView
    fun attach(iLoginView: LoginContract.iLoginView){
        this.iLoginView = iLoginView
        loginModel = LoginModel()
    }
    override fun login(hashMap: HashMap<String, String>, context: Context) {
        loginModel.setLogins(context,hashMap,object : IModelCallback<LoginBean>{
            override fun sucess(data: LoginBean) {
                iLoginView?.LoginSuccess(data)
            }

            override fun failure(string: String) {
                iLoginView?.LoginFailure(string)
            }

        })
    }
    fun datach(){
        if (iLoginView != null){
            iLoginView == null
        }
    }
}