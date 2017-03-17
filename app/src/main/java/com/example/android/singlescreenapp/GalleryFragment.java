package com.example.android.singlescreenapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        ArrayList<Cake> cakes = new ArrayList<Cake>();
        cakes.add(new Cake("Cottage cheese cake", R.drawable.cottage, 3.22));
        cakes.add(new Cake("Strawberry cake", R.drawable.strawb, 4.22));
        cakes.add(new Cake("Honey cake", R.drawable.honey, 6.18));
        cakes.add(new Cake("Bread cake", R.drawable.bread, 4.55));

        final CakeAdapter adapter = new CakeAdapter(getActivity(), cakes);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}
