package com.example.newsapp.AdapterClasses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.ModelClasses.NewsModel;
import com.example.newsapp.R;
import com.example.newsapp.webView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.viewHolder> {
    Context context;
    ArrayList<NewsModel> arrayList;

    public NewsAdapter(Context context, ArrayList<NewsModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public NewsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.viewHolder holder, int position) {
        NewsModel model = arrayList.get(position);
        holder.tvTitle.setText(model.getTitle());
        holder.tvContent.setText(model.getDescription());
        holder.tvAuthor.setText(model.getAuthor());
        holder.tvPublishedTime.setText("Published At: "+model.getPublishedAt());

        Glide.with(context)
                .load(model.getUrlToImage())
                .into(holder.ivImage);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url",model.getUrl());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,tvContent,tvAuthor,tvPublishedTime;
        ImageView ivImage;
        CardView cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.mainHeading);
            tvContent = itemView.findViewById(R.id.content);
            tvAuthor = itemView.findViewById(R.id.author);
            tvPublishedTime = itemView.findViewById(R.id.time);
            ivImage = itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
