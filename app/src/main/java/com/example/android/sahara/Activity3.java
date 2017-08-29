package com.example.android.sahara;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Bhajans> blist;
    BhajanAdapter bhajanAdapter;
    public static Context ctx;
    private static final int VERTICAL_ITEM_SPACE = 48;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        blist = new ArrayList<>(15);

        blist.add(new Bhajans("Durga Aarti","Anuradha Pondwal"));
        blist.add(new Bhajans("Aarti Hanuman Lalla ki","Mahendra Kapoor"));
        blist.add(new Bhajans("Hey Raam","Jagjit Singh"));
        blist.add(new Bhajans("Jai Ganesh Deva","Gulshan Kumar"));
        blist.add(new Bhajans("Om Jai Jagdish Hare","Gulshan Kumar"));
        blist.add(new Bhajans("Om Jai Lakshmi Mata","Gulshan Kumar"));
        blist.add(new Bhajans("Sankat Mochan Naam Tiharo","Mahendra Kapoor"));


        recyclerView = (RecyclerView) findViewById(R.id.rvList3);
        bhajanAdapter = new BhajanAdapter(blist,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));
      recyclerView.addItemDecoration(
               new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(bhajanAdapter);
        ctx = getApplicationContext();



    }

    public static Context getContext(){
        return ctx;
    }
}
