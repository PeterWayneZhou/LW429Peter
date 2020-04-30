package com.example.ludenswishlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

public class Game_Activity extends AppCompatActivity {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DatabaseReference AddToWishList = database.getReference("Game");
    private TextView gameName;
    private TextView gameRelease;
    private TextView platform;

    public TextView gameGenre;
    public TextView gameStudio;
    public ImageView gamePhoto;

    public String title;
    public String console; // platform
    public String genre;
    public String date; //releaseDate
    public String studio;
    public int pic1; //for passing on to wish list
    public int pic2; //for detail page
    public String gameBio;
    public Game g;
    public String newsPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_);
        Intent receivedIntent=getIntent();
        g=(Game)receivedIntent.getSerializableExtra(Keys.GAME_WHOLE);
        title=g.getGameName();
        console=g.getPlatform();
        genre=g.getGenre();
        date=g.getReleaseDate();
        studio=g.getStudio();
        pic1=g.getGameId();
        pic2=g.getGameId2();
        gameBio=g.getBio();
        newsPage=g.getNewsLink();

        TextView gameTitle= findViewById(R.id.gameTitle);
        gameTitle.setText(title);
        TextView gamePlatform= findViewById(R.id.gamePlatform);
        gamePlatform.setText(console);
        TextView gameGenre=findViewById(R.id.gameGenre);
        gameGenre.setText(genre);
        TextView gameRelease=findViewById(R.id.gameReleaseDate);
        gameRelease.setText(date);
        Drawable profileIcon=getResources().getDrawable(pic1, getTheme());
        Drawable icon=getResources().getDrawable(pic2, getTheme());
        ImageView gameImage2=findViewById(R.id.gameImage);
        gameImage2.setImageDrawable(icon);
        TextView introduction=findViewById(R.id.bioBody);
        introduction.setText(gameBio);


        //AddToWishList.setValue("Beyonce");

    }

    public void toWishList(View view) {
        Intent intent = new Intent(this, WishList_Activity.class);
        intent.putExtra(Keys.GAME_TOWISHLIST, g);
        AddToWishList.child(g.getGameName()).setValue(g);
        startActivity(intent);
    }

    public void toNewsPage(View view){
        String url=newsPage;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
