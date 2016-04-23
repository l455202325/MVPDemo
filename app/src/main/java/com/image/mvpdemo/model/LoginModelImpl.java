package com.image.mvpdemo.model;

import android.content.Context;
import android.text.TextUtils;

import com.image.mvpdemo.bean.User;

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
    public void login(String userName, String pwd, OnLoginListener loginListener) {
        if (TextUtils.isEmpty(userName)){
            loginListener.onFailed("用户名为空");
            return;
        }

        if (TextUtils.isEmpty(pwd)){
            loginListener.onFailed("密码为空");
            return;
        }
        if (userName.equals("android") && pwd.equals("123456")){
            loginListener.onSucceed(new User(userName,pwd));
        }else{
            loginListener.onFailed("用户名或者密码错误");
        }
    }
}
