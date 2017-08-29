package com.example.android.sahara;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.android.sahara.R.id.number;

/**
 * Created by HP on 14-Apr-17.
 */

public class HospitalAdapter  extends RecyclerView.Adapter<HospitalAdapter.ListHolder>{

    private ArrayList<Hospital> hlist;
    private Context context;

    public HospitalAdapter(ArrayList<Hospital> hlist, Context context) {
        this.hlist = hlist;
        this.context = context;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item = li.inflate(R.layout.hospital_list,parent,false);
        return new ListHolder(item);
    }

    @Override
    public void onBindViewHolder(final ListHolder holder, int position) {
        final Hospital thisItem = hlist.get(position);
        holder.name.setText(thisItem.getName());
        holder.number.setText(thisItem.getNumber());
        holder.address.setText(thisItem.getAddress());
        holder.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                Log.d(TAG, "onClick: " + holder.number);
                i.setData(Uri.parse("tel:" + thisItem.getNumber()));
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return hlist.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder {
        View mainView;
        TextView name;
        TextView address;
        TextView number;

        public ListHolder(View itemView) {
            super(itemView);
            mainView = itemView;
            name = (TextView) itemView.findViewById(R.id.hospital);
            address = (TextView) itemView.findViewById(R.id.addr);
            number = (TextView) itemView.findViewById(R.id.call);
        }
    }
}
