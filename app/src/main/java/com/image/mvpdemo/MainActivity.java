package com.image.mvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.image.mvpdemo.bean.User;
import com.image.mvpdemo.presenter.LoginPresenter;
import com.image.mvpdemo.views.ILoginView;
import com.kaopiz.kprogresshud.KProgressHUD;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText userNameET;
    private EditText pwdET;
    private Button loginBtn;
    KProgressHUD kProgressHUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "17ad29f21d963dcc4e41f9fa79a4d8d9");
        initView();
    }

    private void initView() {
        userNameET = (EditText) findViewById(R.id.login_user_name);
        pwdET = (EditText) findViewById(R.id.login_user_pwd);
        loginBtn = (Button) findViewById(R.id.login);
        TextView registerTV = (TextView) findViewById(R.id.login_register);


        final LoginPresenter loginPresenter = new LoginPresenter(this,this);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.Login();
            }
        });
        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.register();
            }
        });

        kProgressHUD = KProgressHUD.create(this)
                       .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                       .setLabel("正在登录，请稍候...")
                       .setCancellable(true)
                       .setAnimationSpeed(2)
                       .setDimAmount(0.5f);
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

    @Override
    public void showProgressBar() {
        kProgressHUD.show();
    }

    @Override
    public void dismissProgressBar() {
        kProgressHUD.dismiss();
    }

    @Override
    public void register() {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivityForResult(intent,100);
    }
}
