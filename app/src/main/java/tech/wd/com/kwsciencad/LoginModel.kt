package tech.wd.com.kwsciencad

import android.content.Context
import android.util.Log
import com.kotlinframework.net.network.*

class LoginModel: LoginContract.iLoginModel{
    override fun setLogins(context: Context, hashMap: HashMap<String, String>, modelCallback: IModelCallback<LoginBean>) {
        RetrofitManager.instance.createService(ApiService::class.java)
                .login(UserApi.LOGIN_API,hashMap)
                .compose(NetScheduler.compose())
                .subscribe(object :NetResponseObserver<LoginBean>(context){
                    override fun success(data: LoginBean) {
                        modelCallback?.sucess(data)
                    }
                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        modelCallback?.failure(apiErrorModel.message)
                    }
                })
    }
}