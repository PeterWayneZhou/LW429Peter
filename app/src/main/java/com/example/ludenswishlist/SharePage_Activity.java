package com.example.ludenswishlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;

public class SharePage_Activity extends AppCompatActivity {

    private TextView Gplatform;
    private TextView GreleaseDate;
    private TextView Gname;
    private Drawable backgroundPic;
    private View layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_page_);

        Gname = (TextView)findViewById(R.id.game_name_view);
        GreleaseDate =(TextView)findViewById(R.id.game_releaseDate_view);
        Gplatform = (TextView) findViewById(R.id.game_platform_view);
        layout=findViewById(R.id.sharePage);
        Intent receivingIntent = getIntent();
        Game g = (Game)receivingIntent.getSerializableExtra(Keys.GAME_TOSHAREPAGE);
        Gname.setText("Game Name: " + g.getGameName());
        GreleaseDate.setText("Game Release Date: " + g.getReleaseDate());
        Gplatform.setText("Game Platform: " + g.getPlatform());
        int backGroundPicture=g.getGameId();
        backgroundPic = getResources().getDrawable(backGroundPicture, getTheme());
        layout.setBackground(backgroundPic);
    }
}
