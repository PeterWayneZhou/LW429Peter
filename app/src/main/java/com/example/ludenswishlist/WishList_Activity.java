package com.example.ludenswishlist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WishList_Activity extends AppCompatActivity {

    public ArrayList<Game> games=new ArrayList<>();
    //public ArrayList<String> fullGames=new ArrayList<>(); // 这个arraylist含有10个游戏的名称，用来逐条检索database里边有没有对应游戏.
    private GamesAdapter gamesAdapter;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();  //Game_Activity那边已经设置好database了，这边再设置一次，会不会变成两个了？
    private DatabaseReference AddToWishList = database.getReference("Game"); //是再重设一遍吗？不会抹除game activity那边设好的database吗？
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Luden's Wishlist");
        getIntent();

        //initialData();

        RecyclerView recyclerView = findViewById(R.id.Recycler_View);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        gamesAdapter = new GamesAdapter(AddToWishList, this);
        recyclerView.setAdapter(gamesAdapter);

//        fullGames.add("Darksiders: Genesis");
//        fullGames.add("Two Point Hospital");
//        fullGames.add("Nioh 2");
//        fullGames.add("Animal Crossing: New Horizons");
//        fullGames.add("Mount & Blade II: Bannerlord");
//        fullGames.add("Resident Evil 3: Remake");
//        fullGames.add("Final Fantasy VII: Remake");
//        fullGames.add("Ghost of Tsushima");
//        fullGames.add("Marvel's The Avengers");
//        fullGames.add("Cyberpunk 2077");
    }

    private void initialData() {
        games = new ArrayList<>();
        Intent receivingIntent = getIntent();
        //Game g = (Game)receivingIntent.getSerializableExtra(Keys.GAME_TOWISHLIST);
//        int i;
//        for(i=0; i<9; i++){
//          String forSearchOnDatabase=fullGames.get(i);


//            FirebaseDatabase.getInstance().getReference().child("Game")
//                    .addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                                    Game game = snapshot.getValue(Game.class); //确定这一部可以成功成database的数据生成一个game object吗？
//                                    //System.out.println(game.gameName);
//                                    // games.add(new Game()) 也许不用按照你语音说的去code parameter
//                                    games.add(new Game(game.index,game.gameName, game.genre,game.platform,game.studio,game.releaseDate,game.gameId,game.gameId2,game.bio,game.newsLink));//应该就足够了
//                                }
//                            }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                        }
//                    });
//        AddToWishList.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                games.clear();
//                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                    Game g = dataSnapshot1.getValue(Game.class);
//                    games.add(g); // add all data into list.
//                }
//            }
//
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


//        }



       // games.add(g);
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Home:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.Wishlist:
                Toast.makeText(this,"This is your Wishlist", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.News:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.android.com"));

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
