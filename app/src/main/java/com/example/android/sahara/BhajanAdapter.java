package com.example.android.sahara;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static com.example.android.sahara.rAdapter.context;

/**
 * Created by HP on 13-Apr-17.
 */

public class BhajanAdapter extends RecyclerView.Adapter<BhajanAdapter.ListHolder> {
    public static final String TAG = "BHAJANS";

    private ArrayList<Bhajans> blist;
    public static Context context;
    MediaPlayer mediaPlayer = new MediaPlayer();
    int pos;//global variable for keeping a track of a song

    public BhajanAdapter(ArrayList<Bhajans> blist, Context context) {
        this.blist = blist;
        this.context = context;
    }


    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.bhajan_list_item,parent,false);
        return new ListHolder(itemView);


    }

    @Override
    public void onBindViewHolder(final ListHolder holder, final int position) {
        final boolean[] flag = {false,false};
        Bhajans thisBhajan = blist.get(position);
//        pos = position;
        holder.song.setText(thisBhajan.getSong());
        holder.artist.setText(thisBhajan.getArtist());

        holder.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag[0] == true){
                    holder.img.setImageResource(R.drawable.stop);
                    if(holder.song.getText().toString().equalsIgnoreCase("Durga Aarti"))pos =0 ;
                    else if(holder.song.getText().toString().equalsIgnoreCase("Aarti Hanuman Lalla ki"))pos =1 ;
                    else if(holder.song.getText().toString().equalsIgnoreCase("Hey Raam"))pos =2 ;
                    else if(holder.song.getText().toString().equalsIgnoreCase("Jai Ganesh Deva"))pos =3 ;
                    else if(holder.song.getText().toString().equalsIgnoreCase("Om Jai Jagdish Hare"))pos =4 ;
                    else if(holder.song.getText().toString().equalsIgnoreCase("Om Jai Lakshmi Mata"))pos =5 ;
                    else if(holder.song.getText().toString().equalsIgnoreCase("Sankat Mochan Naam Tiharo"))pos =6 ;

                   holder.song.setTextColor(Color.parseColor("#ef5350"));
                    holder.artist.setTextColor(Color.parseColor("#ef5350"));
                    flag[0] = false;
                MyTask myTask = new MyTask();
                myTask.execute(position);
            }

                else{
                    holder.img.setImageResource(R.drawable.play);
                    holder.song.setTextColor(Color.GRAY);
                    holder.artist.setTextColor(Color.GRAY);

                    mediaPlayer.stop();
//                    holder.song.setTextColor(0xffffff00);
                    flag[0] = true;
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return blist.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder {
        TextView song;
        TextView artist;
        ImageView img;
        View mainView;

        public ListHolder(View itemView) {
            super(itemView);
            mainView = itemView;
            song = (TextView) itemView.findViewById(R.id.song);
            artist = (TextView) itemView.findViewById(R.id.artist);
            img = (ImageView) itemView.findViewById(R.id.img);

        }
    }

    public  class MyTask extends AsyncTask<Integer,Void,Void>{

        public MyTask() {
            super();
        }

        @Override
        protected Void doInBackground(Integer... params) {
            mediaPlayer.start();
            return null;
        }

        @Override
        protected void onPreExecute() {

            context = Activity3.getContext();
            switch (pos)
            {

                case  0 : {mediaPlayer = MediaPlayer.create(context,R.raw.bhajan1); Log.d(TAG, "onPreExecute: " + pos); break;}
                case  1 : {mediaPlayer = MediaPlayer.create(context,R.raw.bhajan4);Log.d(TAG, "onPreExecute: " + pos); break;}
                case  2 : {mediaPlayer = MediaPlayer.create(context,R.raw.bhajan2);Log.d(TAG, "onPreExecute: " + pos); break;}
                case  3 : {mediaPlayer = MediaPlayer.create(context,R.raw.bhajan5);Log.d(TAG, "onPreExecute: " + pos); break;}
                case  4 : {mediaPlayer = MediaPlayer.create(context,R.raw.bhajan7);Log.d(TAG, "onPreExecute: " + pos); break;}
                case  5 : {mediaPlayer = MediaPlayer.create(context,R.raw.bhajan6);Log.d(TAG, "onPreExecute: " + pos); break;}
                case  6 : {mediaPlayer = MediaPlayer.create(context,R.raw.bhajan3);Log.d(TAG, "onPreExecute: " + pos); break;}
                default:
                    Toast.makeText(context, "Song Not Available!", Toast.LENGTH_SHORT).show();


            }


            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Void aVoid) {
            super.onCancelled(aVoid);
        }
    }

}
