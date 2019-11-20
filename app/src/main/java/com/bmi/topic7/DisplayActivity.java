package com.bmi.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class DisplayActivity extends AppCompatActivity {
 private ListView listView;
private Map <String, String> dictionary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        listView=findViewById(R.id.listview);
        dictionary=new HashMap<>();
        read();
        ArrayAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                new ArrayList<>(dictionary.keySet()));
        listView.setAdapter(adapter);
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String key=adapterView.getItemAtPosition(i).toString();
        String meaning=dictionary.get(key);
        Intent intent=new Intent(DisplayActivity.this,MeaningActivity.class);
        intent.putExtra("meaning",meaning);
        startActivity(intent);
    }
});
    }
    private void read(){
        try {
            FileInputStream fos=openFileInput("words.txt");
            InputStreamReader isr=new InputStreamReader(fos);
            BufferedReader br=new BufferedReader(isr);
            String line="";
            while ((line=br.readLine()) !=null){
                String [] parts=line.split("->");
                dictionary.put(parts[0],parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
