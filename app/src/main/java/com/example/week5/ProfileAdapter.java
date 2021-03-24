package com.example.week5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import  java.util.Random;
public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder> {

    private String[] data;
    private String[] pics;
    public ProfileAdapter(String [] data,String[] pics){
        this.data = data;
        this.pics = pics;
    }
    @Override
    public int getItemViewType(final int position) {
        return R.layout.text_row_item;
    }
    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        holder.getView().setText(data[position]);
        Picasso.get().load(this.pics[position]).into(holder.getDp());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}
