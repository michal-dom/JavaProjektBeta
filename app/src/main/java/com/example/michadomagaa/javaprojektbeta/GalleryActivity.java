package com.example.michadomagaa.javaprojektbeta;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.File;
import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    private GridView gridView;
    private GridViewAdapter gridViewAdapter;
    private String path = "/storage/sdcard/DCIM/projekt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        /*
        * gridView obiekt klasy GridView z biblioteki android.widget.GridView
        * gridViewAdapter obiekt klasy GridViewAdapter stworzonej przeze mnie
        * public abstract class ViewGroup extends View implements ViewParent, ViewManager
        */

        gridView = (GridView) findViewById(R.id.grid_gallery);
        gridViewAdapter = new GridViewAdapter(this, R.layout.gallery_grid_item, getData());

        gridView.setAdapter(gridViewAdapter);

        final int size = gridView.getChildCount();
        Log.e("size", size+"");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                ImageItems item = (ImageItems) parent.getItemAtPosition(i);
                Intent intent = new Intent(GalleryActivity.this, ImageActivity.class);
                intent.putExtra("name", item.getTitle());
                intent.putExtra("path", getFolderPath()+"/Camera");
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getFolderPath(){
        File dcimFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        return dcimFile.getPath();
    }

    private ArrayList<ImageItems> getData(){
        final ArrayList<ImageItems> imageItemes = new ArrayList<>();
        File f = new File(getFolderPath()+"/Camera");
        File[] files = f.listFiles();
        //TypedArray images = getResources().obtainTypedArray(R.array.image_ads);
        for(int i = 0; i < files.length; i++){
            final String imagePath = f.getPath() + "/" + files[i].getName();
            Bitmap bitmap = Imaging.decodeImage(imagePath);

            imageItemes.add(new ImageItems(bitmap, files[i].getName()));
        }
        return imageItemes;
    }
}
