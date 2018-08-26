package com.example.softheart.englishnumbers.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.softheart.englishnumbers.R;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    ArrayList<Song>songs;
    CustomOnItemClick customOnItemClick;
    public SongAdapter(ArrayList<Song>songs, CustomOnItemClick customOnItemClick) {
        this.songs=songs;
        this.customOnItemClick=customOnItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item,parent,false);
     final ViewHolder viewHolder=new ViewHolder(view);
       view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             customOnItemClick.onItemCick(view,viewHolder.getPosition());
           }
       });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.numberImageView.setImageResource(songs.get(position).getImageNumber());
        holder.number.setText(songs.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView number;
        ImageView numberImageView;
        public ViewHolder(View itemView) {
            super(itemView);
                number=itemView.findViewById(R.id.number_tv);
                numberImageView=itemView.findViewById(R.id.number_iv);
        }
    }
}
