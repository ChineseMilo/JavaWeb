package com.xb;

public class User {
    private String name;
    private String adress;

    public User() {
    }

    public User(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }


    public void show(){
        System.out.println(213);
    }

}
