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

        val yourList = arrayListOf<YourModel>()
        yourList.add(YourModel())
        yourList.add(YourModel())
        yourList.add(YourModel())

        //Set your sharedPreferences
        val sharedPreferencesUtil: SharedPreferencesUtil = SharedPreferencesUtil.getInstance(this)
        sharedPreferencesUtil.setStringPreferences(NAME, "Mohamed AbuAzneh")
        sharedPreferencesUtil.setLongPreferences(PHONE_NUMBER, 962554545450)
        sharedPreferencesUtil.setIntPreferences(NUMBER_OF_POINT, 5)
        sharedPreferencesUtil.setBooleanPreferences(IS_USER_LOGGED_IN, true)


        //get your sharedPreferences
        sharedPreferencesUtil.getStringPreferences(NAME, "")
        sharedPreferencesUtil.getLongPreferences(PHONE_NUMBER, 0)
        sharedPreferencesUtil.getIntPreferences(NUMBER_OF_POINT, 0)
        sharedPreferencesUtil.getBooleanPreferences(IS_USER_LOGGED_IN, false)

        //save List<Object> to SharedPreferences
        sharedPreferencesUtil.saveList(LIST, yourList)

        //get List<Object> from SharedPreferences
        var myList = sharedPreferencesUtil.getList<YourModel>(LIST)


    }


}