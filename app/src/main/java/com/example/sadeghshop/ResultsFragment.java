package com.example.sadeghshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ResultsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false);
    }

    @Override
    public void onResume() {

        //getting our list data
        String[] titles = getResources().getStringArray(R.array.results_titles);
        String[] prices = getResources().getStringArray(R.array.results_prices);
        int[] images = {R.drawable.wallpaper, R.drawable.wallpaper, R.drawable.wallpaper
                , R.drawable.wallpaper, R.drawable.wallpaper, R.drawable.wallpaper,
                R.drawable.wallpaper, R.drawable.wallpaper, R.drawable.wallpaper,
                R.drawable.wallpaper};
        RecyclerView recyclerResultsView = getView().findViewById(R.id.recycler_results_view);
        ResultsAdapter adapter = new ResultsAdapter(getContext(), titles, prices, images);
        recyclerResultsView.setAdapter(adapter);
        recyclerResultsView.setLayoutManager(new LinearLayoutManager(getContext()));


        super.onResume();
    }
}