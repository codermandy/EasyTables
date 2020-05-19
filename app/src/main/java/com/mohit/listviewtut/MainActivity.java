package com.mohit.listviewtut;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView textView2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView2 =findViewById(R.id.textView2);
        listView =findViewById(R.id.myListView);
        SeekBar seekBar =findViewById(R.id.seekBar);
        seekBar.setMax(20);

        //seekbar ko foreward karne pe change bhi toh krna hai
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Toast.makeText(MainActivity.this,"Populating table of "+progress,Toast.LENGTH_SHORT).show();
                populate(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void populate(int table) {
        ArrayList<String> mulTable =new ArrayList<>();

        for(int i=1;i<=10;i++){
            mulTable.add(table+" X "+ i + " = " + table *i);

        }
        //array adapter android ki class hoti hai jo array ko java code me daalne me help krti hai
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mulTable);
        listView.setAdapter(arrayAdapter);
        textView2.setText("Multiplication table of "+table);

    }


}
