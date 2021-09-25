package com.example.devbitz.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.devbitz.Interface.ItemClickListener;
import com.example.devbitz.R;

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView foodName;
    public ImageView foodImage;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;

    }

    public FoodViewHolder(View itemView){
        super(itemView);

        foodName = (TextView) itemView.findViewById(R.id.food_name);
        foodImage =(ImageView) itemView.findViewById(R.id.food_image);

        itemView.setOnClickListener(this);
    }


//v == view
    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
