package com.image.mvpdemo.model;

import com.image.mvpdemo.bean.User;

/**
 * Created by Administrator on 2016-04-24.
 */
public interface ILoginModel {

    public  void login (String userName,String pwd,OnLoginListener loginListener);

    public interface OnLoginListener{
        public  void onSucceed(User user);
        public void onFailed(String msg);
    }
}
