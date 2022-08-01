package com.example.snakeladdertask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {


    String[] tasks ={"give small treat to the King","offer a chocolate to the King","make coffee for the King",
                "offer a glass of water to the King","offer a packet of chips to the King","give a small massage to the King",
                "give 10Rs. to the King","offer tea to the King","take a autograph from King"};
    Button comp,home;
    TextView loser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        comp=findViewById(R.id.button5);
        home=findViewById(R.id.button6);
        loser=findViewById(R.id.textView8);
        Random random=new Random();
        int x=random.nextInt(9);
        loser.setText(tasks[x]);

        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pp=new Intent(MainActivity2.this,MainActivity5.class);
                startActivity(pp);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity4.class);
                startActivity(intent);


            }
        });


    }


}