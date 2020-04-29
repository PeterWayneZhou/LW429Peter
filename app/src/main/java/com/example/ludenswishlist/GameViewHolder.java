package com.example.ludenswishlist;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class GameViewHolder extends RecyclerView.ViewHolder {
    public CardView cardView;
    public TextView gameName;
    public TextView gameGenre;
    public TextView gamePlatform;
    public TextView gameReleaseDate;
    public TextView gameStudio;
    public ImageView gamePhoto;
    public Button detailButton;
    public Button shareButton;

    public GameViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public GameViewHolder(View itemView, final Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        gameName = (TextView) itemView.findViewById(R.id.game_name_view);
        gameGenre = (TextView) itemView.findViewById(R.id.game_genre_view);
        gamePlatform = (TextView) itemView.findViewById(R.id.game_platform_view);
        gameReleaseDate = (TextView) itemView.findViewById(R.id.game_releaseDate_view);
        gameStudio = (TextView) itemView.findViewById(R.id.game_studio_view);
        gamePhoto = (ImageView) itemView.findViewById(R.id.game_image_view);
        detailButton= itemView.findViewById(R.id.detail_button);
        shareButton = (Button) itemView.findViewById(R.id.share_button);
    }
}
