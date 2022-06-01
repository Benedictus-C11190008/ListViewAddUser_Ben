package com.example.listviewadduser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList id, nama, pass;
    List<DataModel> data;
    LayoutInflater inflater;

    public CustomAdapter(Context c , List data){
        this.c = c;
        this.data = data;
        inflater = LayoutInflater.from(c);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.my_lvelement, null);
        TextView tvid = (TextView) view.findViewById(R.id.textView);
        tvid.setText(String.valueOf(data.get(i)));
        return view;
    }
}
