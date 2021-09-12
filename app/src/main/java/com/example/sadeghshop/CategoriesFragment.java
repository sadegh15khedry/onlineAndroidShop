package com.example.sadeghshop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesFragment extends Fragment {
    private RecyclerView recyclerCategoriesView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onResume() {

        String[] categories = getResources().getStringArray(R.array.categoriesValues);
        recyclerCategoriesView = getView().findViewById(R.id.recycler_categories_view);
        CategoriesAdapter adapter = new CategoriesAdapter(getContext(), categories);
        recyclerCategoriesView.setAdapter(adapter);
        recyclerCategoriesView.setLayoutManager(new LinearLayoutManager(getContext()));
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());


        super.onResume();
    }
}
