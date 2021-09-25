package com.example.devbitz.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.devbitz.Interface.ItemClickListener;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnContextClickListener {
    public TextView txtMenuName;
    public ImageView imageView;

    private ItemClickListener itemClickListener;

    public MenuViewHolder(View itemView) {
        super(itemView);
        txtMenuName=(textView)itemView.findViewById(R.id.menu_name);
        imageView=(imageView)itemView.findViewById(R.id.imageView);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener= itemClickListener;
    }
    public void onClick(View view){
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
