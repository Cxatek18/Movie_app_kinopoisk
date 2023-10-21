package com.team.movies;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private List<Review> reviews = new ArrayList<>();

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false
        );
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviews.get(position);
        holder.textViewNameReviwer.setText(review.getAuthor());
        holder.textViewTextReviwer.setText(review.getReview());
        int colorResId = getColorBackground(String.valueOf(review.getType()));
        int color = ContextCompat.getColor(holder.itemView.getContext(), colorResId);
        holder.cardReview.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    private int getColorBackground(String typeReview){
        int colorResId;
        switch (typeReview){
            case "Позитивный":
                colorResId = android.R.color.holo_green_light;
                break;
            case "Нейтральный":
                colorResId = android.R.color.darker_gray;
                break;
            case "Негативный":
                colorResId = android.R.color.holo_red_light;
                break;
            default:
                colorResId = android.R.color.darker_gray;
        }
        return colorResId;
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder{

        private final CardView cardReview;
        private final TextView textViewNameReviwer;
        private final TextView textViewTextReviwer;
        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            cardReview = itemView.findViewById(R.id.cardReview);
            textViewNameReviwer = itemView.findViewById(R.id.textViewNameReviwer);
            textViewTextReviwer = itemView.findViewById(R.id.textViewTextReviwer);
        }
    }
}
