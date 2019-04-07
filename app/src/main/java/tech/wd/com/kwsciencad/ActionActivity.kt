package tech.wd.com.kwsciencad

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.jpush.android.api.JPushInterface

class ActionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)
        setContentView(R.layout.activity_action)
    }
}
