package com.example.sadeghshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder> {
    private Context context;
    private String[] titles;
    private String[] prices;
    private int[] images;

    public ResultsAdapter(Context context, String[] titles, String[] prices, int[] images) {
        this.context = context;
        this.titles = titles;
        this.prices = prices;
        this.images = images;
    }

    @NonNull
    @Override
    public ResultsAdapter.ResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_categories, parent, false);
        return new ResultsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultsAdapter.ResultsViewHolder holder, int position) {
        holder.myTitle.setText(this.titles[position]);
        holder.myPrice.setText(this.prices[position]);
        holder.myImageView.setImageResource(this.images[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ResultsViewHolder extends RecyclerView.ViewHolder {
        TextView myTitle;
        TextView myPrice;
        ImageView myImageView;

        public ResultsViewHolder(@NonNull View itemView) {
            super(itemView);
            myTitle = itemView.findViewById(R.id.results_item_title);
            myPrice = itemView.findViewById(R.id.results_item_price);
            myImageView = itemView.findViewById(R.id.results_item_image);
        }
    }


}
