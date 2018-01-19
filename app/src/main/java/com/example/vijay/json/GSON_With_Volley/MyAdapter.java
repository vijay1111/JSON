package com.example.vijay.json.GSON_With_Volley;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.vijay.json.R;

/**
 * Created by vijay on 12/1/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ProductViewHolder> {
    private Context context;
    private User[] data;

    public MyAdapter(Context context, User[] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        final User user = data[position];
        Glide.with(context).load(user.getAvatarUrl()).into(holder.imageView);
        holder.textView.setText(user.getLogin());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, user.getLogin()+"was clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textuser);
            imageView = itemView.findViewById(R.id.imguser);
        }
    }
}