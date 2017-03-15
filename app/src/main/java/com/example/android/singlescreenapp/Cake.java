package com.example.android.singlescreenapp;

/**
 * Created by Ivars on 2017.03.09..
 */

public class Cake {

    private static final int NO_IMAGE_PROVIDED = -1;
    private String mCakeName;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private double mPrice;

    public Cake(String CakeName, int ImageResourceId, double Price) {
        mCakeName = CakeName;
        mImageResourceId = ImageResourceId;
        mPrice = Price;
    }

    public String GetCakeName() {
        return mCakeName;
    }

    public int GetImageResourceID() {
        return mImageResourceId;
    }

    public double GetPrice() {
        return mPrice;
    }

}
