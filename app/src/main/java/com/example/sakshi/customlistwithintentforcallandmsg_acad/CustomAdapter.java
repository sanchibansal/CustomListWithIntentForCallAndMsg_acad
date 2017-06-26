package com.example.sakshi.customlistwithintentforcallandmsg_acad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sakshi on 26-06-2017.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Data> mList;
    LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList arrayList){
        this.context= context;
        mList=arrayList;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.row_item,parent,false);
        TextView name = (TextView)convertView.findViewById(R.id.name);
        TextView contact = (TextView)convertView.findViewById(R.id.contact);
        name.setText(mList.get(position).getName());            //setting name text view
        contact.setText(mList.get(position).getContact());      //setting contact text View
         return convertView;
    }
}
