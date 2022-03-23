package com.anzeh.sharedprefutils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anzeh.sharedprefrepo.User
import com.anzeh.utils.PrefConstants.IS_USER_LOGGED_IN
import com.anzeh.utils.PrefConstants.LIST
import com.anzeh.utils.PrefConstants.NAME
import com.anzeh.utils.PrefConstants.NUMBER_OF_POINT
import com.anzeh.utils.PrefConstants.PHONE_NUMBER
import com.anzeh.utils.SharedPreferencesUtil


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


}