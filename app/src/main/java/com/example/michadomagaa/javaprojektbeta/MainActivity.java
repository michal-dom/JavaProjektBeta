package com.example.michadomagaa.javaprojektbeta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv1, tv2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, Environment.DIRECTORY_DCIM,Toast.LENGTH_SHORT).show();


        tv1 = (TextView) findViewById(R.id.main_gallery);
        tv1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this,
                        GalleryActivity.class);
                intent.putExtra("root", "root");
                startActivity(intent);
            }
        });

        tv2 = (TextView) findViewById(R.id.main_camera);
        tv2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this,
                        CameraActivity.class);
                intent.putExtra("root", "root");
                startActivity(intent);
            }
        });
    }
}
