package com.example.android.sahara;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.android.sahara.Activity1.et2;
import static com.example.android.sahara.R.id.hours;
import static com.example.android.sahara.R.id.minutes;
import static com.example.android.sahara.R.id.number;
import static java.lang.Integer.parseInt;

public class Activity5 extends AppCompatActivity {
    public static final String TAG = "Alert";
    EditText hrs;
    EditText mins;
    Button button;
    EditText messg;
    long end_time,start_time;
    MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        hrs = (EditText) findViewById(R.id.hours);
        mins = (EditText) findViewById(R.id.minutes);
        button = (Button) findViewById(R.id.btn);
        messg = (EditText) findViewById(R.id.message);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long h,m;

                if(hrs.getText().toString().isEmpty())h=0;
                else {
                    h = Long.parseLong(String.valueOf(hrs.getText().toString()));
                }
                if (mins.getText().toString().isEmpty())m=0;
                else {
                    m = Long.parseLong(String.valueOf(mins.getText().toString()));
                }
                end_time = h*3600*1000 + m*60*1000;
                start_time = System.currentTimeMillis();
                Toast.makeText(Activity5.this, "Alert Generated!!", Toast.LENGTH_SHORT).show();
                Task task = new Task();
                task.execute(end_time);

            }
        });

    }

    class Task extends AsyncTask<Long,Long,Boolean>{


        @Override
        protected Boolean doInBackground(Long... params) {
            if(params[0]==0)return false;
            long end = params[0];
            while ((System.currentTimeMillis()-start_time)<params[0]){
                Log.d(TAG, "doInBackground: "+"Diff = " + (System.currentTimeMillis()-start_time));
                publishProgress((System.currentTimeMillis()-start_time));
            }
            return true;
        }

        @Override
        protected void onPreExecute() {
            Log.d(TAG, "onPreExecute: ");
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if(aBoolean == true){
                ActivityCompat.requestPermissions(Activity5.this,new String[]{Manifest.permission.SEND_SMS},1);
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,i,0);
                SmsManager sms = SmsManager.getDefault();
                String smessage = messg.getText().toString();

                    sms.sendTextMessage("9565689120", null,"Reminder : "+smessage, pi, null);
                mediaplayer = MediaPlayer.create(Activity5.this,R.raw.alert);
                mediaplayer.start();

                Toast.makeText(Activity5.this, "Alert Sent Successfully!!", Toast.LENGTH_SHORT).show();
            }
            if(aBoolean == false) Toast.makeText(Activity5.this, "Enter the valid end time", Toast.LENGTH_SHORT).show();

            super.onPostExecute(aBoolean);
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            Log.d(TAG, "onProgressUpdate: " + values[0]);
            super.onProgressUpdate(values);
        }
    }
}
