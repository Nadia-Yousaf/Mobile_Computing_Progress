package com.example.ide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> friendList = new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        friendList.add("Musa");
        friendList.add("Esa");
        friendList.add("Saad");
        friendList.add("Ibrahim");
        ListView listView = findViewById(R.id.myListView);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friendList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Name", friendList.get(position));
                startActivity(intent);
            }
        });
    }

    public void AddItem(View view) {
        View input = findViewById(R.id.input);
        //friendList.add(input.getTex().toString());
        friendList.add(input.toString());
        arrayAdapter.notifyDataSetChanged();

    }
};