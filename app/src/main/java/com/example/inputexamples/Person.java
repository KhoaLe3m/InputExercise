package com.example.inputexamples;

import android.os.Parcelable;

import java.io.Serializable;

public class Person implements Serializable {
    private String FullName;
    private Integer Phone;
    private boolean Gender;
    private String Knowlegde;
    private int Age;
    private String Sports;
    private String Music;

    public Person(String FullName,int Phone,boolean Gender,String Knowledge,int Age,String Sports,String Music) {
        this.FullName = FullName;
        this.Phone = Phone;
        this.Gender = Gender;
        this.Knowlegde = Knowledge;
        this.Age= Age;
        this.Sports = Sports;
        this.Music = Music;
    }

    public Person() {
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }

    public String getKnowlegde() {
        return Knowlegde;
    }

    public void setKnowlegde(String learn) {
        Knowlegde = learn;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getSports() {
        return Sports;
    }

    public void setSports(String sports) {
        Sports = sports;
    }

    public String getMusic() {
        return Music;
    }

    public void setMusic(String music) {
        Music = music;
    }

    @Override
    public String toString() {
        return String.format("Person{Name:%s,,Age:%d,Phone:%d,Gender:%s,Knowledge:%s,Sports:%s,Music:%s }",
                this.getFullName(),this.getAge(),this.getPhone(),this.isGender()?"Male":"Female",
                this.getKnowlegde(),this.getSports(),this.getMusic());
    }
}
