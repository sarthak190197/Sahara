package com.example.android.sahara;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.start;

/**
 * Created by HP on 11-Apr-17.
 */

public class rAdapter extends RecyclerView.Adapter<rAdapter.ListItemHolder> {

    private ArrayList<String> ulist;
    public static Context context;


    public rAdapter(ArrayList<String> ulist,Context context) {
        this.ulist = ulist;
        this.context = context;
    }

    @Override
    public ListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_view,parent,false);
        return new ListItemHolder(itemView);
        }




    @Override
    public void onBindViewHolder(final ListItemHolder holder, int position) {
        String t = ulist.get(position);
//        holder.mathurSabseBadaChutiya.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        holder.textView.setText(t);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context = MainActivity.getContext();

                if(holder.textView.getText().toString().equalsIgnoreCase("Contacts")){
                    Intent i =new Intent(context,Activity2.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);

                }
                else if(holder.textView.getText().toString().equalsIgnoreCase("Bhajans")){
                    Intent i =new Intent(context,Activity3.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);

                }
                else if(holder.textView.getText().toString().equalsIgnoreCase("SMS")){
                    Intent i =new Intent(context,Activity1.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);

                }
                else if(holder.textView.getText().toString().equalsIgnoreCase("Alert")){
                    Intent i =new Intent(context,Activity5.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);

                }
                else if(holder.textView.getText().toString().equalsIgnoreCase("Hospitals")){
                    Intent i =new Intent(context,Activity4.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);

                }

            }


        });

    }

    @Override
    public int getItemCount() {
        return ulist.size();
    }



public class ListItemHolder extends RecyclerView.ViewHolder {
        TextView textView;
//        View mathurSabseBadaChutiya;
        public ListItemHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
//            mathurSabseBadaChutiya = itemView;
        }

    }


}
