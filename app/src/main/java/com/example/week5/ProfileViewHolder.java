package com.example.week5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileViewHolder extends RecyclerView.ViewHolder {


    private TextView name;
    private ImageView dp;

    public ProfileViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.randomText);
        dp = itemView.findViewById(R.id.dp);
    }

    public TextView getView(){
        return name;
    }
    public ImageView getDp() {return dp;}
}
