package com.example.android.sahara;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> utilities;
    RecyclerView recyclerView;
    rAdapter listAdapter;
    public static Context ctx;

//    public static ArrayList<String> chutiyamathur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        utilities= new ArrayList<>(5);
        utilities.add("SMS");
        utilities.add("Contacts");
        utilities.add("Bhajans");
        utilities.add("Hospitals");
        utilities.add("Alert");
        recyclerView=(RecyclerView)findViewById(R.id.rvList);
        listAdapter = new rAdapter(utilities,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
        ctx = getApplicationContext();




    }
    public  static Context getContext(){return ctx;}

//    public static ArrayList<String> getChutiyamathur(){
//        return chutiyamathur;
//    }
}
