package com.example.day00.bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    /*
    * 注册
    * */
    String sBeanUri="http://yun918.cn/study/public/index.php/register";

   @GET("index.php/register")
    Observable<Bean> Regist();

   /*
   * 登录
   * */
   String logUri="http://yun918.cn/study/public/";

   @GET("index.php/login")
    Observable<Bean> Login();

   /*
   * 验证码
   * */
   String AtgetUri="http://yun918.cn/study/public/";

   @GET("index.php/verify")
    Observable<Bean> Atget();
}
