package com.image.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.image.mvpdemo.bean.User;
import com.image.mvpdemo.presenter.LoginPresenter;
import com.image.mvpdemo.views.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText userNameET;
    private EditText pwdET;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        userNameET = (EditText) findViewById(R.id.login_user_name);
        pwdET = (EditText) findViewById(R.id.login_user_pwd);
        loginBtn = (Button) findViewById(R.id.login);

        final LoginPresenter loginPresenter = new LoginPresenter(this,this);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.Login();

            }
        });

    }

    @Override
    public String getUserName() {
        return userNameET.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return pwdET.getText().toString().trim();
    }

    @Override
    public void onSucceed(User user) {
        Toast.makeText(this, "用户名密码正确", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
