package com.image.mvpdemo.views;

import com.image.mvpdemo.bean.User;

/**
 * Created by Administrator on 2016-04-23.
 */
public interface ILoginView {

    public String getUserName();
    public String getPwd();
    public void onSucceed(User user);
    public void onFailed(String msg);

}
