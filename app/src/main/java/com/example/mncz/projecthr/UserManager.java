package com.example.mncz.projecthr;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by MNCZ on 9/28/2017.
 */

public class UserManager {
    //KEY_PREFS ไว้สำหรับเป็น key ของ SharedPreference
    private final String KEY_PREFS = "prefs_user";
    //ชื่อ key ที่ไว้เซฟ username ใน SharedPreference
    private final String KEY_USERNAME = "username";
    //ชื่อ key ที่ไว้เซฟ password ใน SharedPreference
    private final String KEY_PASSWORD = "password";

    private SharedPreferences Prefs;
    private SharedPreferences.Editor Editor;

   /* //รับค่า Context เพื่อเอาไว้ใช้สำหรับ getSharedPreference
    //@param context*/

    public UserManager(Context context) {
        Prefs = context.getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE);
        Editor = Prefs.edit();
    }

/*    ทำการเช็ค Username กับ Password ใน SharedPreferences<br />
    โดยเงื่อนไข EditText ของ Username และ password ต้องไม่เป็นค่าว่าง <br />
    และค่าที่ได้ ต้องตรงกับใน SharedPreferences
    @param username - username จาก EditText ที่ใส่
    @param password - password จาก EditText ที่ใส่
    @return หากใส่ข้อมูล ให้ส่งค่ากลับเป็น true, ถ้าใส่ผิดก็ส่ง false*/

    public boolean checkLoginValidate(String username, String password) {
        String realUsername = Prefs.getString(KEY_USERNAME, "");
        String realPassword = Prefs.getString(KEY_PASSWORD, "");

        if ((!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) &&
                username.equals(realUsername) &&
                password.equals(realPassword)) {
            return true;
        }
        return false;
    }
}
