package model;

import config.InputMethods;

import java.util.Date;

public class User {
    private int userId;
    private String username;
    private String password;
    private String fullname;
    private String birthday;
    private String tel;

    public User() {
    }

    public User(int userId, String username, String password, String fullname, String birthday, String tel) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.birthday = birthday;
        this.tel = tel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void inputData() { // id ở phần service
        System.out.println("Tên đăng nhập: ");
        this.username = InputMethods.getString();
        System.out.println("Mật khẩu: ");
        this.password = InputMethods.getString();
        System.out.println("Họ và tên: ");
        this.fullname = InputMethods.getString();
        System.out.println("Ngày sinh: (dd/mm/yyyy) ");
        this.birthday = InputMethods.getBirthday();
        System.out.println("Điện thoại: ");
        this.tel = InputMethods.getString();
    }

    @Override
    public String toString() {
        return
                "ID: " + userId + "\n" +
                "Tên đăng nhập: " + username + "\n" +
                "Mật khẩu: " + password + "\n" +
                "Họ và tên: " + fullname + "\n" +
                "Ngày sinh: " + birthday + "\n" +
                "Điện thoại: " + tel
                ;
    }
}
