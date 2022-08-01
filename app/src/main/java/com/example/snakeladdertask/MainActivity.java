package com.example.snakeladdertask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity<snakes> extends AppCompatActivity {

    ImageButton board[][]=new ImageButton[10][10];
    private static final int[][] positions={ {R.id.imageButton1,R.id.imageButton2,R.id.imageButton3,R.id.imageButton4,R.id.imageButton5,R.id.imageButton6,R.id.imageButton7,R.id.imageButton8,R.id.imageButton9,R.id.imageButton10},
        {R.id.imageButton11,R.id.imageButton12,R.id.imageButton13,R.id.imageButton14,R.id.imageButton15,R.id.imageButton16,R.id.imageButton17,R.id.imageButton18,R.id.imageButton19,R.id.imageButton20},
        {R.id.imageButton21,R.id.imageButton22,R.id.imageButton23,R.id.imageButton24,R.id.imageButton25,R.id.imageButton26,R.id.imageButton27,R.id.imageButton28,R.id.imageButton29,R.id.imageButton30},
        {R.id.imageButton31,R.id.imageButton32,R.id.imageButton33,R.id.imageButton34,R.id.imageButton35,R.id.imageButton36,R.id.imageButton37,R.id.imageButton38,R.id.imageButton39,R.id.imageButton40},
        {R.id.imageButton41,R.id.imageButton42,R.id.imageButton43,R.id.imageButton44,R.id.imageButton45,R.id.imageButton46,R.id.imageButton47,R.id.imageButton48,R.id.imageButton49,R.id.imageButton50},
        {R.id.imageButton51,R.id.imageButton52,R.id.imageButton53,R.id.imageButton54,R.id.imageButton55,R.id.imageButton56,R.id.imageButton57,R.id.imageButton58,R.id.imageButton59,R.id.imageButton60},
        {R.id.imageButton61,R.id.imageButton62,R.id.imageButton63,R.id.imageButton64,R.id.imageButton65,R.id.imageButton66,R.id.imageButton67,R.id.imageButton68,R.id.imageButton69,R.id.imageButton70},
        {R.id.imageButton71,R.id.imageButton72,R.id.imageButton73,R.id.imageButton74,R.id.imageButton75,R.id.imageButton76,R.id.imageButton77,R.id.imageButton78,R.id.imageButton79,R.id.imageButton80},
        {R.id.imageButton81,R.id.imageButton82,R.id.imageButton83,R.id.imageButton84,R.id.imageButton85,R.id.imageButton86,R.id.imageButton87,R.id.imageButton88,R.id.imageButton89,R.id.imageButton90},
        {R.id.imageButton91,R.id.imageButton92,R.id.imageButton93,R.id.imageButton94,R.id.imageButton95,R.id.imageButton96,R.id.imageButton97,R.id.imageButton98,R.id.imageButton99,R.id.imageButton100}

    };
    HashMap<Integer,Integer> snake=new HashMap<Integer,Integer>();
    HashMap<Integer,Integer> ladders=new HashMap<Integer,Integer>();

    TextView head;
    Button p1,p2;
    public ImageView dice;
    int ply1=1;
    int ply2=0;
    int currpos1=0;
    int currpos2=0;
    int getsix1=0,getsix2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         snake.put(33,0);
        snake.put(24,4);
        snake.put(90,60);
        snake.put(64,51);
        snake.put(86,56);
        snake.put(46,18);
        snake.put(98,68);

        ladders.put(2,50);
        ladders.put(5,26);
        ladders.put(19,69);
        ladders.put(35,54);
        ladders.put(62,94);
        ladders.put(67,97);

        head = findViewById(R.id.textView);
        p1 = findViewById(R.id.button);
        p2 = findViewById(R.id.button2);
        dice = findViewById(R.id.imageView);
        dice.setBackgroundResource(R.drawable.dice1);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = (ImageButton) findViewById(positions[i][j]);
            }
        }
        head.setText("Lets Start");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        head.setText("");
        Toast.makeText(this, "goti will be visible when you get a SIX", Toast.LENGTH_SHORT).show();


        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ply1 == 1) {
                    Random random = new Random();
                    int x = random.nextInt(6) + 1;

                    switch(x)
                    {
                        case 1: dice.setBackgroundResource(R.drawable.dice1);
                            break;

                        case 2: dice.setBackgroundResource(R.drawable.dice2);
                            break;

                        case 3: dice.setBackgroundResource(R.drawable.dice3);
                            break;

                        case 4: dice.setBackgroundResource(R.drawable.dice4);
                            break;

                        case 5: dice.setBackgroundResource(R.drawable.dice5);
                            break;

                        case 6: dice.setBackgroundResource(R.drawable.dice6);
                            break;


                    }
                    if (getsix1 == 0) {
                        if (x != 6) {
                            ply1 = 0;
                            ply2 = 1;
                        } else {
                            board[0][0].setBackgroundResource(R.drawable.red_dot1);
                            getsix1 = 1;

                        }
                    } else {
                        getpos(x,ply1,ply2);

                        if (x != 6) {
                            ply1 = 0;
                            ply2 = 1;
                        }
                    }


                } else {
                    Toast.makeText(MainActivity.this, "Its Player2's Turn", Toast.LENGTH_SHORT).show();
                }
            }
        });

     p2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if (ply2 == 1) {
                 Random random = new Random();
                 int x = random.nextInt(6) + 1;

                 switch(x)
                 {
                     case 1: dice.setBackgroundResource(R.drawable.dice1);
                         break;

                     case 2: dice.setBackgroundResource(R.drawable.dice2);
                         break;

                     case 3: dice.setBackgroundResource(R.drawable.dice3);
                         break;

                     case 4: dice.setBackgroundResource(R.drawable.dice4);
                         break;

                     case 5: dice.setBackgroundResource(R.drawable.dice5);
                         break;

                     case 6: dice.setBackgroundResource(R.drawable.dice6);
                         break;


                 }

                 if (getsix2 == 0) {
                     if (x != 6) {
                         ply1 = 1;
                         ply2 = 0;
                     } else {
                         board[0][0].setBackgroundResource(R.drawable.green_dot1);
                         getsix2 = 1;
                     }
                 } else {


                    getpos(x,ply1,ply2);

                     if (x != 6) {
                         ply2 = 0;
                         ply1 = 1;
                     }
                 }


             } else {
                 Toast.makeText(MainActivity.this, "Its Player1's Turn", Toast.LENGTH_SHORT).show();
             }
         }

     });

    }
    void getpos(int x,int ply1,int ply2)
    {
        if(ply1==1)
        {
            if(currpos1+x==99)
            {

                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
            else if(currpos1+x<99)
            {
                int z=currpos1+x;
                int ei=Math.max(0,(currpos1%10));
                int si=Math.max(0,(currpos1/10));
                if(currpos1==currpos2)
                {
                    board[si][ei].setBackgroundResource(R.drawable.green_dot1);

                }
                else
                {
                    board[si][ei].setBackgroundResource(R.color.transparent);
                }
                int fei=Math.max(0,(z%10));
                int fsi=Math.max(0,(z/10));

                board[fsi][fei].setBackgroundResource(R.drawable.red_dot1);

                if(snake.containsKey(z))
                {
                    int p= snake.get(z);
                    int  nfei=Math.max(0,(p%10));
                    int  nfsi=Math.max(0,(p/10));

                    if(currpos2==z)
                    {
                        board[fsi][fei].setBackgroundResource(R.drawable.green_dot1);

                    }
                    else
                    {
                        board[fsi][fei].setBackgroundResource(R.color.transparent);
                    }
                    board[nfsi][nfei].setBackgroundResource(R.drawable.red_dot1);
                    currpos1= p;
                }
                else if(ladders.containsKey(z))
                {
                    int p= ladders.get(z);
                    int  nfei=Math.max(0,(p%10));
                    int  nfsi=Math.max(0,(p/10));

                    if(currpos2==z)
                    {
                        board[fsi][fei].setBackgroundResource(R.drawable.green_dot1);

                    }
                    else
                    {
                        board[fsi][fei].setBackgroundResource(R.color.transparent);
                    }
                    board[nfsi][nfei].setBackgroundResource(R.drawable.red_dot1);
                    currpos1= p;
                }
                else
                    currpos1=z;
            }
        }
        else
        {
            if(currpos2+x==99)
            {

                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
            else if(currpos2+x<99)
            {
                int y=currpos2+x;
                int ei=Math.max(0,currpos2%10);
                int si=Math.max(0,currpos2/10);
                if(currpos1==currpos2)
                {
                    board[si][ei].setBackgroundResource(R.drawable.red_dot1);

                }
                else
                {
                    board[si][ei].setBackgroundResource(R.color.transparent);
                }
                int fei=Math.max(0,y%10);
                int fsi=Math.max(0,y/10);

                board[fsi][fei].setBackgroundResource(R.drawable.green_dot1);

                if(snake.containsKey(y))
                {
                    int p= snake.get(y);
                   int  nfei=Math.max(0,(p%10));
                   int  nfsi=Math.max(0,(p/10));

                    if(currpos1==y)
                    {
                        board[fsi][fei].setBackgroundResource(R.drawable.red_dot1);

                    }
                    else
                    {
                        board[fsi][fei].setBackgroundResource(R.color.transparent);
                    }
                    board[nfsi][nfei].setBackgroundResource(R.drawable.green_dot1);
                    currpos2=p;
                }
                else if(ladders.containsKey(y))
                {
                    int p= ladders.get(y);
                   int  nfei=Math.max(0,(p%10));
                   int  nfsi=Math.max(0,(p/10));

                    if(currpos1==y)
                    {
                        board[fsi][fei].setBackgroundResource(R.drawable.red_dot1);

                    }
                    else
                    {
                        board[fsi][fei].setBackgroundResource(R.color.transparent);
                    }
                    board[nfsi][nfei].setBackgroundResource(R.drawable.green_dot1);
                    currpos2= p;
                }
                else
                currpos2=y;
            }
        }

    }
}