package com.example.sadeghshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {
    private String[] categories;
    private Context context;

    public CategoriesAdapter (Context context , String[] categories ){
        this.context = context;
        this.categories = categories;

    }
    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.categories_row, parent ,false);
        return new CategoriesViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        holder.myCategory.setText(this.categories[position]);
    }



    @Override
    public int getItemCount() {
        return categories.length;
    }

    public class CategoriesViewHolder extends RecyclerView.ViewHolder {
        TextView myCategory;
        public CategoriesViewHolder(@NonNull View itemView){
            super(itemView);
            myCategory = itemView.findViewById(R.id.categoriesItem);
        }
    }
}
