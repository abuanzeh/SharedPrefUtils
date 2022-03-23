# Preview
This library came to facilitate the process of saving and reading data from anywhere
Within the application and without the need to retype the code again , 
All data can be saved so that you can save a complete list and read it from anywhere within the application.

# Dependencies 
Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the dependency :
```
implementation 'com.github.abuanzeh:SharedPrefUtils:1.0.1'
```

# How to use
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


   
