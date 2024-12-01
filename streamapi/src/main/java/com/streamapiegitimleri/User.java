package com.streamapiegitimleri;

public class User {
    private String userName;
    private String lastName;
    private Long age;

    public User(String userName, String lastName, Long age) {
        this.userName = userName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
