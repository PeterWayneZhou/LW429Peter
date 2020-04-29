package com.example.ludenswishlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.io.Serializable;
import java.util.List;


public class GamesAdapter extends Adapter<GameViewHolder> implements Serializable {
    private List<Game> games;
    private Context context;

    public GamesAdapter(List<Game> games, Context context) {
        this.games = games;
        this.context = context;
    }

    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_game, parent, false);
        return new GameViewHolder(view, context);
    }



    public void onBindViewHolder(final GameViewHolder holder, int position) {
        final Game game = games.get(position);
        holder.gameName.setText(game.gameName);
        holder.gamePlatform.setText(game.platform);
        holder.gameGenre.setText(game.genre);
        holder.gameReleaseDate.setText(game.releaseDate);
        holder.gameStudio.setText(game.studio);
        holder.gamePhoto.setImageResource(game.gameId);
        //for sharing's parameters
        final String gameTitle=game.gameName;
        final String console=game.platform;
        final String when=game.releaseDate;
        final int image1=game.gameId;

        holder.detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, Game_Activity.class);
                intent.putExtra(Keys.GAME_WHOLE, game);

                context.startActivity(intent);
            }
        });
        holder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SharePage_Activity.class);
                Game g = new Game(gameTitle,when,console,image1);
                intent.putExtra(Keys.GAME_TOSHAREPAGE, g);
                context.startActivity(intent);
            }
        });
    }



    public int getItemCount() {
        return games.size();
    }
}
