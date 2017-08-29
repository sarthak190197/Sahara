package com.example.android.sahara;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by HP on 11-Apr-17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ListHolder> {

    ArrayList<Contacts> clist;
    Context context;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

public ContactsAdapter(ArrayList<Contacts> clist,Context context)
{
    this.clist=clist;
    this.context = context;
}


    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item,parent,false);
        return new ListHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        final Contacts thisContact = clist.get(position);
        holder.imageView.setImageResource(thisContact.getImg());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("name",thisContact.getName());
                bundle.putString("relation",thisContact.getRelation());
                bundle.putString("number",thisContact.getNumber());
                bundle.putInt("image",thisContact.getImg());
                FragmentImg frag = new FragmentImg();
                frag.setArguments(bundle);
                fragmentManager = Activity2.getFragManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragFrame,frag);
                fragmentTransaction.commit();


            }
        });


    }

    @Override
    public int getItemCount() {
        return clist.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public ListHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img);

        }
    }
}
