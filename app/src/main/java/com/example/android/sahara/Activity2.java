package com.example.android.sahara;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

   /* public  static*/ ArrayList<Contacts> contactsArrayList;
    ContactsAdapter contactsAdapter;
    RecyclerView recyclerView;


    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        contactsArrayList = new ArrayList<>(15);
        contactsArrayList.add(new Contacts(R.drawable.person2,"Asha","Wife","8077476931"));
        contactsArrayList.add(new Contacts(R.drawable.person1,"Rahul","Son","9565689120"));
        contactsArrayList.add(new Contacts(R.drawable.person5,"Rohit","Son","9958421789"));
        contactsArrayList.add(new Contacts(R.drawable.person6,"Rohan","Son","9565689120"));
        contactsArrayList.add(new Contacts(R.drawable.person3,"Naina","Daughter","9565689120"));
        contactsArrayList.add(new Contacts(R.drawable.person4,"Ayesha","Daughter","9936405785"));
        contactsArrayList.add(new Contacts(R.drawable.person7,"Johnny","Grandson","9958421789"));
        contactsArrayList.add(new Contacts(R.drawable.person8,"Akshay","Grandson","9958421789"));
        contactsArrayList.add(new Contacts(R.drawable.police1,"Police","","101"));


       /* Intent intent = new Intent(Activity2.this, Activity1.class);
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",(Serializable)contactsArrayList);
        intent.putExtra("BUNDLE",args);
        startActivity(intent); */




        recyclerView = (RecyclerView) findViewById(R.id.rvList2);
        contactsAdapter = new ContactsAdapter(contactsArrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contactsAdapter);
        fragmentManager = getSupportFragmentManager();
    }

    public static FragmentManager getFragManager(){
        return fragmentManager;
    }

//    public  static  ArrayList<Contacts> getContactsArrayList(){return contactsArrayList;}
}


