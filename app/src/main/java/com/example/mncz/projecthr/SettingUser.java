package com.example.mncz.projecthr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by MNCZ on 9/21/2017.
 */

public class SettingUser extends Activity {

    private Button Login;
    private EditText Username;
    private EditText Password;
    private Context Context;
    private UserManager Manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_user);

        Context = this;

        Login = (Button)findViewById(R.id.btConfirm);
        Username = (EditText)findViewById(R.id.username);
        Password = (EditText)findViewById(R.id.password);
        Manager = new UserManager(this);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });
    }

    private void checkLogin(){
        String username = Username.getText().toString().trim();
        String password = Password.getText().toString().trim();

        boolean isSuccess = Manager.checkLoginValidate(username, password);

        if (isSuccess) {
            Intent intent = new Intent(Context, SettingUser.class);
            startActivity(intent);
        } else {
            String message = getString(R.string.register_error_message);
            Toast.makeText(Context, message, Toast.LENGTH_SHORT).show();
        }
    }
}

