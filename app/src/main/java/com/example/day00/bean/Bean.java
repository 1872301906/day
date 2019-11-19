package com.example.day00.bean;

public class Bean {
    private String username;
    private String password;
    private String phone;
    private String verify;

    public Bean(String username, String password, String phone, String verify) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.verify = verify;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
}
