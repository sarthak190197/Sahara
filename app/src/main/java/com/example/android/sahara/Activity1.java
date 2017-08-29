package com.example.android.sahara;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

//import static com.example.android.sahara.Activity2.getContactsArrayList;

public class Activity1 extends AppCompatActivity {
    public static final String TAG = "SMS";
    EditText et1;
    public static EditText et2;
    Button button;
    String message,number;
    RecyclerView recyclerView;
    SmsAdapter sAdapter;
    ArrayList<SMSContact> mlist;

//    public static ArrayList<Contacts> clist;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        et1 = (EditText) findViewById(R.id.message);
        et2 = (EditText) findViewById(R.id.number);
        button = (Button) findViewById(R.id.btn);
//        clist = new ArrayList<>(20);
//        clist = ((Activity2)getParent()).getContactsArrayList();
//        clist = Activity2.getContactsArrayList();
//        for(Contacts c : clist) Log.d(TAG, "onCreate: "+c);

        /*Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Contacts> clist = (ArrayList<Contacts>) args.getSerializable("ARRAYLIST");*/




//        Log.d(TAG, "onCreate: "+clist.get(0).getName());

        mlist = new ArrayList<>(20);
        mlist.add(new SMSContact("Asha","8077476931"));
        mlist.add(new SMSContact("Rahul","9565689120"));
        mlist.add(new SMSContact("Rohit","9958421789"));
        mlist.add(new SMSContact("Rohan","9565689120"));
        mlist.add(new SMSContact("Naina","9565689120"));
        mlist.add(new SMSContact("Ayesha","9936405785"));
        mlist.add(new SMSContact("Johnny","9958421789"));
        mlist.add(new SMSContact("Akshay","9958421789"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(Activity1.this,new String[]{Manifest.permission.SEND_SMS},1);
                message = et1.getText().toString();
                number = et2.getText().toString();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,i,0);
                SmsManager sms = SmsManager.getDefault();
                for(int it=0 ; it<3 ; ++it) {
                    sms.sendTextMessage(number, null, message, pi, null);
                }
                Toast.makeText(Activity1.this, "Message Sent Successfully!!", Toast.LENGTH_SHORT).show();

            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.rvList4);
        sAdapter = new SmsAdapter(mlist,this);
//        Log.d(TAG, "onCreate: " + sAdapter.getSMSNumber());
        recyclerView.addItemDecoration(
                new android.support.v7.widget.DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sAdapter);




    }
}
