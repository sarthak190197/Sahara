package com.example.android.sahara;

/**
 * Created by HP on 11-Apr-17.
 */

public class Contacts {
    String name;
    String relation;
    String number;
    int img;

    public Contacts(int img,String name,String relation,String number) {
        this.name = name;
        this.relation = relation;
        this.number = number;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
