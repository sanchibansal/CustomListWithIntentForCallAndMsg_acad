package com.example.sakshi.customlistwithintentforcallandmsg_acad;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    ArrayList<Data> mList;
    CustomAdapter mCustomAdapter;
    ListView listView;      //declaring arraylist, customAdapter and listView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        mList= new ArrayList<Data>();
        mList.add(new Data("Pushpa","9988776655"));     //adding name and contact in the arraylist
        mList.add(new Data("Latha","9988778874"));
        mList.add(new Data("Arjun","9988778844"));
        mList.add(new Data("Kiran","7988778877"));
        mList.add(new Data("Arnav","9968778877"));

        mCustomAdapter = new CustomAdapter(this,mList);
        listView.setAdapter(mCustomAdapter);            //setting list to the custom adapter

        registerForContextMenu(listView);   //register for context menu


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0,1,1,"Call");
        menu.add(0,2,2,"Send SMS");     //adding call and text menu in the context menu
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int IndexSelected = info.position;
        if (item.getGroupId() == 0 && item.getItemId() == 1) {
            //calling action
            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+mList.get(IndexSelected).getContact()));
            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
                return true;
            }
        }
        if (item.getGroupId() == 0 && item.getItemId() == 2) {
            //sms action
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",mList.get(IndexSelected).getContact(),null));
            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
                return true;
            }
        }

            return super.onContextItemSelected(item);
        }

    }
