package com.example.vijay.json.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vijay.json.R;

/**
 * Created by vijay on 12/6/17.
 */

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammerViewHolder> {
    String data[];

    public ProgrammingAdapter(String data[]) {
        this.data = data;
    }

    @Override
    public ProgrammerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ProgrammerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgrammerViewHolder holder, int position) {
        String title = data[position];
        holder.textView.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProgrammerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ProgrammerViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgicon);
            textView = itemView.findViewById(R.id.textView);

        }
    }

}
