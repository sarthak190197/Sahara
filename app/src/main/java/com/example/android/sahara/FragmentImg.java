package com.example.android.sahara;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HP on 12-Apr-17.
 */

public class FragmentImg extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        String name = bundle.getString("name");
        String relation = bundle.getString("relation");
        final String number = bundle.getString("number");
        int img = bundle.getInt("image");
        View rootView = inflater.inflate(R.layout.list_contacts,container,false);
        ((ImageView) rootView.findViewById(R.id.img)).setImageResource(img);
        ((TextView) rootView.findViewById(R.id.name)).setText(name);
        ((TextView) rootView.findViewById(R.id.relation)).setText(relation);
        ((TextView) rootView.findViewById(R.id.number)).setText(number);
        TextView no = (TextView) rootView.findViewById(R.id.number);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + number));
                startActivity(i);

            }
        });
        return rootView;


//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
