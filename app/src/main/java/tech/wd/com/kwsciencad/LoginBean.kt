package tech.wd.com.kwsciencad

import android.provider.ContactsContract

data class LoginBean (
        val messsage: String,
        val result: Result,
        val status: String
){
    data class Result(
            val headPic: String,
            val nickname: String,
            val phone: String,
            val sessionId: String,
            val sex: Int,
            val userId: Int
    )
}
