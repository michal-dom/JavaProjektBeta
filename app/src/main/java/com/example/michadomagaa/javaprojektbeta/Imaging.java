package com.example.michadomagaa.javaprojektbeta;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

/**
 * Created by Michał Domagała on 2017-04-27.
 */

public class Imaging {

    public Imaging(){};

    public static Bitmap decodeImage(String path){
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inSampleSize = 1;

        File file = new File(path);
        bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        return bitmap;
    }
}
