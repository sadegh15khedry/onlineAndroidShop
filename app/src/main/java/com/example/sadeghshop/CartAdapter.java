package com.example.sadeghshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{
    private Context context;
    private String[] titles;
    private String[] prices;
    private int[] images;
    private int[] quantity;

    public CartAdapter(Context context, String[] titles, String[] prices, int[] images, int[] quantity) {
        this.context = context;
        this.titles = titles;
        this.prices = prices;
        this.images = images;
        this.quantity = quantity;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_cart, parent, false);
        return new CartAdapter.CartViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.myTitle.setText(this.titles[position]);
        holder.myPrice.setText(this.prices[position]);
        holder.myImageView.setImageResource(this.images[position]);
    }

    @Override
    public int getItemCount() {
        return  titles.length;
    }


    public class CartViewHolder extends RecyclerView.ViewHolder {
        TextView myTitle;
        TextView myPrice;
        ImageView myImageView;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            myTitle = itemView.findViewById(R.id.cart_item_title);
            myPrice = itemView.findViewById(R.id.cart_item_price);
            myImageView = itemView.findViewById(R.id.cart_item_image);
        }
    }
}
