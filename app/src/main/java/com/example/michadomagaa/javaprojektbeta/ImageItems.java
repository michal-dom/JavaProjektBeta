package com.example.michadomagaa.javaprojektbeta;

import android.graphics.Bitmap;

/**
 * Created by Michał Domagała on 2017-04-27.
 */

public class ImageItems {

    private Bitmap image;
    private String title;
    private long size;

    public ImageItems(Bitmap image, String title, long size){
        super();
        this.image = image;
        this.title = title;
        this.size = size;
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

    public long getSize() {
        return size;
    }
}
