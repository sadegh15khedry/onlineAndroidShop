package com.example.sadeghshop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CartFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
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

        int[] q = {1, 1, 1, 1, 1};
        RecyclerView recyclerCartView = getView().findViewById(R.id.cart_recycler_view);
        CartAdapter adapter = new CartAdapter(getContext(), titles, prices, images, q);
        recyclerCartView.setAdapter(adapter);
        recyclerCartView.setLayoutManager(new LinearLayoutManager(getContext()));


        super.onResume();
    }

}
