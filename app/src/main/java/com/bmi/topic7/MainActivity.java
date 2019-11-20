package com.bmi.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button btnList,btnViewAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnList=findViewById(R.id.btnList);
        btnViewAdd=findViewById(R.id.btnViewAdd);
        btnList.setOnClickListener(this);
        btnViewAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnList){
            Intent intent=new Intent(MainActivity.this,DisplayActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent1=new Intent(MainActivity.this,AddWordsActivity.class);
            startActivity(intent1);
        }

    }
}
