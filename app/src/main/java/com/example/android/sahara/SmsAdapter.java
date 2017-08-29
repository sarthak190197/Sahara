package com.example.android.sahara;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.delay;
import static android.content.ContentValues.TAG;


/**
 * Created by HP on 13-Apr-17.
 */

public class SmsAdapter  extends RecyclerView.Adapter<SmsAdapter.ListHolder>{

    private ArrayList<SMSContact> mlist;
    private Context context;
    String num;

    public SmsAdapter(ArrayList<SMSContact> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemsView = li.inflate(R.layout.list_sms_contacts,parent,false);
        return new ListHolder(itemsView);
    }

    @Override
    public void onBindViewHolder(final ListHolder holder, int position) {
        SMSContact thisContact = mlist.get(position);
        holder.name.setText(thisContact.getName());
        holder.number.setText(thisContact.getNumber());
        holder.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: "+"Here");
                num = holder.number.getText().toString();
                holder.name.setTextColor(Color.MAGENTA);
                holder.number.setTextColor(Color.MAGENTA);
                long start_time = System.currentTimeMillis();
                while (System.currentTimeMillis()-start_time<1000);
                Activity1.et2.setText(num);
                holder.name.setTextColor(Color.DKGRAY);
                holder.number.setTextColor(Color.DKGRAY);


                Log.d(TAG, "onClick: " + num);


            }
        });

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder{
        View mainView;
        TextView name;
        TextView number;

        public ListHolder(View itemView) {
            super(itemView);
            mainView = itemView;
            name = (TextView) itemView.findViewById(R.id.name);
            number = (TextView) itemView.findViewById(R.id.number);

        }
    }


}
