package com.example.android.singlescreenapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ivars on 2017.03.09..
 */

public class CakeAdapter extends ArrayAdapter<Cake> {

    public CakeAdapter(Activity context, ArrayList<Cake> cakes) {
        super(context, 0, cakes);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.gallery_list_item, parent, false);
        }

        final Cake currentCake = getItem(position);

        TextView cakeName = (TextView) listItemView.findViewById(R.id.cake_name);
        cakeName.setText(currentCake.GetCakeName());

        ImageView cakeImage = (ImageView) listItemView.findViewById(R.id.cake_image);
        cakeImage.setImageResource(currentCake.GetImageResourceID());

        return listItemView;
    }
}
