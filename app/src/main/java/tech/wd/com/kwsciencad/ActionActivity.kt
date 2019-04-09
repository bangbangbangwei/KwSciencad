package tech.wd.com.kwsciencad

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import cn.jpush.android.api.JPushInterface
import com.jcodecraeer.xrecyclerview.XRecyclerView
import kotlinx.android.synthetic.main.activity_action.*

class ActionActivity : AppCompatActivity(),LoginContract.iLoginView, View.OnClickListener {

    lateinit var loginPresentre: LoginPresentre

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)
        initView()
        initData()
    }

    private fun initView() {
        //极光推送
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)
        //login点击事件
        login.setOnClickListener(this)
    }

    private fun initData() {
        //初始化Presenter
        loginPresentre = LoginPresentre()
    }

    /**
     * 登陆成功
     */
    override fun LoginSuccess(loginBean: LoginBean) {
        Toast.makeText(this,loginBean.messsage,Toast.LENGTH_LONG).show()
        Log.i("tag+++++++++++",loginBean.messsage+"")
            var intent = Intent(this,ProductActivity::class.java)
            startActivity(intent)
    }

    /**
     * 登陆失败
     */
    override fun LoginFailure(string: String) {

    }

    /**
     * View点击事件
     */
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.login -> login()
        }
    }

    fun login(){
        var params = HashMap<String,String>()
        params.put("phone", "18612991023")
        params.put("pwd", "111111")
        loginPresentre.attach(this)
        loginPresentre.login(params,this)
    }


    /**
     * 销毁
     */
    override fun onDestroy() {
        super.onDestroy()
        loginPresentre.datach()
    }
}
