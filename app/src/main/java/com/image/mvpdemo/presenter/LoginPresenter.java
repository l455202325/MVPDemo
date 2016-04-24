package com.image.mvpdemo.presenter;

import android.content.Context;

import com.image.mvpdemo.bean.User;
import com.image.mvpdemo.model.ILoginModel;
import com.image.mvpdemo.model.LoginModelImpl;
import com.image.mvpdemo.views.ILoginView;

/**
 * Created by Administrator on 2016-04-24.
 */
public class LoginPresenter {

    //presenter 是连接 View 及 Model的 桥梁 需要有这两个对应的对象
    private ILoginView loginView;
    private ILoginModel loginModel;

    //View层 一般在Activity中实现，可以在构造方法中传入进来；
    //Model层一般已经自己实现，可以直接new出来，如果需要上下文对象一般可以在，presenter构造方法中传入进来
    public LoginPresenter(Context context,ILoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl(context);
    }

    public void Login(){
        loginView.showProgressBar();
        loginModel.login(loginView.getUserName(), loginView.getPwd(), new ILoginModel.OnLoginListener() {
            @Override
            public void onSucceed(User user) {
                loginView.dismissProgressBar();
                loginView.onSucceed(user);
            }

            @Override
            public void onFailed(String msg) {
                loginView.dismissProgressBar();
                loginView.onFailed(msg);
            }
        });
    }

    public void register(){
        loginView.register();
    }
}
