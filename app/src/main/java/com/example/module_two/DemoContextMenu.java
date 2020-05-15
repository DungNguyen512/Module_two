package com.example.module_two;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

// Gắn data vào listView

public class DemoContextMenu extends AppCompatActivity {
    ListView listView;
    String[] footballName = {"Football 1", "Football 2", "Football 3", "Football 4", "Football 5"};
    ArrayAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_context_menu);
        listView = (ListView) findViewById(R.id.my_list_view);
        listViewAdapter = new ArrayAdapter(DemoContextMenu.this, android.R.layout.simple_list_item_1, footballName);
        listView.setAdapter(listViewAdapter);
        //Bắt buộc phải register ContextMenu và gắn listView
        registerForContextMenu(listView);
    }

    //KHởi tạo contextMenu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.popup_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.menu_haleluja:
                Toast.makeText(DemoContextMenu.this,"Haleluja "+footballName[adapterContextMenuInfo.position],Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_trustingod:
                Toast.makeText(DemoContextMenu.this,"Trust In God "+footballName[adapterContextMenuInfo.position],Toast.LENGTH_LONG).show();
                break;
        }
        ;
        return super.onContextItemSelected(item);
    }
}
