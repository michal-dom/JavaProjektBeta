package com.example.michadomagaa.javaprojektbeta;

import android.graphics.Bitmap;

/**
 * Created by Michał Domagała on 2017-04-27.
 */

public class ImageItems {

    private Bitmap image;
    private String title;

    public ImageItems(Bitmap image, String title){
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage(){
        return image;
    }

    public void setImage(){
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
