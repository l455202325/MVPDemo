package com.image.mvpdemo.views;

import com.image.mvpdemo.bean.User;

/**
 * Created by Administrator on 2016-04-23.
 */
public interface ILoginView {
//在MVP模式中，View所需方法分析
    //1.要从界面中获取信息的话需要写在View里面
    //2.界面中的逻辑操作完成时要写在View中
    //总结：用户输入及给用户输出信息需要写在view中
    public String getUserName();
    public String getPwd();
    public void onSucceed(User user);
    public void onFailed(String msg);

}
