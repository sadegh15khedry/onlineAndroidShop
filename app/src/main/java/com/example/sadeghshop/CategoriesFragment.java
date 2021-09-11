package com.example.sadeghshop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoriesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ArrayList<CategoriesItem> categoriesItems = new ArrayList<>();
        categoriesItems.add(new CategoriesItem(R.drawable.homer_simpson,"هومر","سیمسون"));
        categoriesItems.add(new CategoriesItem(R.drawable.homer_simpson,"هومر","سیمسون"));
        categoriesItems.add(new CategoriesItem(R.drawable.homer_simpson,"هومر","سیمسون"));
        return inflater.inflate(R.layout.fragment_categories,container,false);
    }
}
