package com.image.mvpdemo.presenter;

import android.os.Handler;

import com.image.mvpdemo.bean.User;
import com.image.mvpdemo.model.ILoginModel;
import com.image.mvpdemo.model.LoginModelImpl;
import com.image.mvpdemo.views.ILoginView;

/**
 * Created by Administrator on 2016-04-24.
 */
public class LoginPresenter {

    private ILoginView loginView;
    private ILoginModel loginModel;
    private Handler handler = new Handler();

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    public void Login(){
        loginModel.login(loginView.getUserName(), loginView.getPwd(), new ILoginModel.OnLoginListener() {
            @Override
            public void onSucceed(User user) {
                loginView.onSucceed(user);
            }

            @Override
            public void onFailed(String msg) {
                loginView.onFailed(msg);
            }
        });
    }
}
