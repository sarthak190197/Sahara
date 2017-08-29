package com.example.android.sahara;

/**
 * Created by HP on 13-Apr-17.
 */

public class SMSContact {
    String name;
    String number;

    public SMSContact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
