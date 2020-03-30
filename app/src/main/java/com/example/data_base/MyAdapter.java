package com.example.data_base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter {
    private LayoutInflater inflater;
    private int layout;
    private List<Pub> pubs;

    public MyAdapter(Context context, int resource, List<Pub> pubs) {
        super(context, resource, pubs);
        this.pubs = pubs;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView flagView = (ImageView) view.findViewById(R.id.photo);
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView capitalView = (TextView) view.findViewById(R.id.description);

        Pub pub = pubs.get(position);

        flagView.setImageResource(pub.getPhotoResource());
        nameView.setText(pub.getName());
        capitalView.setText(pub.getDescription());

        return view;
    }
}
