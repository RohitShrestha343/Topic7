package com.bmi.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class AddWordsActivity extends AppCompatActivity implements View.OnClickListener {
EditText etwords,etmeaning;
Button  btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_words);
        etwords=findViewById(R.id.words);
        etmeaning=findViewById(R.id.meaning);
        btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        save();
    }
  private void save(){
      try {
          PrintStream printStream =new PrintStream(openFileOutput("words.txt",MODE_PRIVATE|MODE_APPEND));
          printStream.println(etwords.getText().toString()+"->"+etmeaning.getText().toString());
          Toast.makeText(this, "Saved to"+getFilesDir(), Toast.LENGTH_SHORT).show();
      } catch (IOException e) {
          Log.d("Dictionary App", "Error: "+e.toString());
          e.printStackTrace();
      }
  }
}
