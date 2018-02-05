package com.example.user.android_assgn_11_3;

/**
 * Created by USER on 05-02-2018.
 */

import android.graphics.Bitmap;

public class Employee {
    //setting bitmap values
    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }

    private Bitmap bmp;
    private String name;
    private int age;
    //constructor
    public Employee(Bitmap b, String n, int k) {
        bmp = b;
        name = n;
        age = k;
    }
    //generating getters and setters
    public Bitmap getBitmap() {
        return bmp;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setBitmap(){
        this.bmp=bmp;
    }

}