package com.image.mvpdemo.model;

import android.content.Context;
import android.text.TextUtils;

import com.image.mvpdemo.bean.User;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016-04-24.
 */
public class LoginModelImpl implements ILoginModel {
    private Context context;
    public LoginModelImpl(Context context) {
        this.context = context;
    }

    //进行对应的逻辑操作
    @Override
    public void login(String userName, String pwd, final OnLoginListener loginListener) {
        if (TextUtils.isEmpty(userName)){
            loginListener.onFailed("用户名为空");
            return;
        }

        if (TextUtils.isEmpty(pwd)){
            loginListener.onFailed("密码为空");
            return;
        }

        final User user = new User();
        user.setUsername(userName);
        user.setPassword(pwd);
        user.login(context, new SaveListener() {
            @Override
            public void onSuccess() {
                loginListener.onSucceed(user);
            }

            @Override
            public void onFailure(int i, String s) {
                loginListener.onFailed(s);
            }
        });
    }
}
