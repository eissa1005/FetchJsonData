package com.example.eissa.fetchjsondata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

      public static TextView data;
      Button btnsend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data=(TextView)findViewById(R.id.fetchdata);
        btnsend=(Button)findViewById(R.id.btnsend);
       btnsend.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FetchData process = new FetchData();
               process.execute();
           }
       });
    }


}

