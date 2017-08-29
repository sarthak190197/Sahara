package com.example.android.sahara;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;

import java.util.ArrayList;

public class Activity4 extends AppCompatActivity {
    ArrayList<Hospital> hospitalArrayList;
    RecyclerView recyclerView;
    HospitalAdapter hospitalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        hospitalArrayList = new ArrayList<>(20);
        hospitalArrayList.add(new Hospital("Fortis Hospital, Noida","B-22, Sector 62, Gautam Buddh Nagar, Noida, Uttar Pradesh 201301","+91 120 430 0222"));
        hospitalArrayList.add(new Hospital("Indraprastha Apollo Hospital","Sarita Vihar, Delhi Mathura road \n" +
                "New Delhi - 110076, India"," +91 11 29871090"));
        hospitalArrayList.add(new Hospital("Max Superspecialty Hospital, Saket","1,2 Press Enclave Road,\n" +
                "Saket, New Delhi 110 017","+91 11 2651 5050"));
        hospitalArrayList.add(new Hospital("Artemis Hospital, Gurgaon","Sector 51, Gurgaon,\n" +
                "Haryana 122001"," 0124 676 7000"));
        hospitalArrayList.add(new Hospital("Medanta - The Medicity, Delhi","Sector 38, CH Bakhtawar Singh Road,\n" +
                "Islampur Colony, Near Rajiv Chowk,\n" +
                "Gurgaon, Haryana 122001, India","+91 124 414 1414"));
        hospitalArrayList.add(new Hospital("AIIMS (All India Institute of Medical Sciences), New Delhi","Ansari Nagar, New Delhi - 110029","+91 11 26588500"));



        recyclerView = (RecyclerView) findViewById(R.id.rvList5);
        hospitalAdapter = new HospitalAdapter(hospitalArrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(
                new android.support.v7.widget.DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(hospitalAdapter);






    }
}
