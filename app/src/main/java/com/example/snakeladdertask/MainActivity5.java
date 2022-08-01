package com.example.snakeladdertask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

public class MainActivity5 extends AppCompatActivity {
   ImageView photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        photo=findViewById(R.id.taskphoto);
        Intent cam=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cam,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap img=(Bitmap)data.getExtras().get("data");
        photo.setImageBitmap(img);
    }
}