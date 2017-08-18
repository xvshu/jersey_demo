package com.xvshu.cn.vo;

import java.io.Serializable;

/**
 * Created by xvshu on 2017/8/16.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
