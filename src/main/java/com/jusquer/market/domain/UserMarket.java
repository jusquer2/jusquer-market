package com.jusquer.market.domain;

public class UserMarket {
    private String name;
    private String password;
    private String user;

    public UserMarket(String name, String password, String user){
        this.name = name;
        this.password = password;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
