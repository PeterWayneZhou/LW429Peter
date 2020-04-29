package com.example.ludenswishlist;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Game> games;
    private GamesAdapter gamesAdapter;
    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Luden's Wishlist - HOME");
        getIntent();

        initialData();

        recyclerView =(RecyclerView)findViewById(R.id.Recycler_View);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        gamesAdapter = new GamesAdapter(games, this);
        recyclerView.setAdapter(gamesAdapter);
    }

    public void initialData() {
        games = new ArrayList<>();
        games.add(new Game(0,"Darksiders: Genesis", "Genre: Action", "Platform: PS4, XB1, PC", "Studio: THQ Nordic", "Release Date: 02.14.2020", R.drawable.darksiders1, R.drawable.darksiders2, "DARKSIDERS: GENESIS is an action/adventure game that tears its way through hordes of demons, angels, and everything in-between on its way to Hell and back with guns blazing and swords swinging. Genesis gives players their first look at the world of DARKSIDERS before the events of the original game.", "https://www.ign.com/articles/2019/12/04/darksiders-genesis-review"));
        games.add(new Game(1,"Two Point Hospital", "Genre: Simulation", "Platform: PS4, XB1, PC, NS", "Studio: SEGA", "Release Date: 02.25.2020", R.drawable.twopoint1, R.drawable.twopoint2,"A spiritual successor to Bullfrog Productions' 1997 game Theme Hospital, players are tasked with constructing and operating an empire of hospitals in the fictional Two Point County, with the goal of curing patients of fictitious, comical ailments. Because visiting real hospitals is unpopular, the emphasis on humour to lighten the mood was deemed important by the developers.", "https://www.ign.com/articles/2018/09/06/two-point-hospital-review" ));
        games.add(new Game(2,"Nioh 2", "Genre: Action", "Platform: PS4", "Studio: Team Ninja", "Release Date: 03.12.2020", R.drawable.nioh21, R.drawable.nioh22, "Nioh 2 is an action role-playing game developed by Team Ninja. As a prequel to Nioh (2017), the game allows players to create their own playable character, who was a yōkai spirit. Players are equipped with a variety of weapons such as odachi and kusarigama, and earn new skills as they progress in the game.", "https://www.ign.com/articles/nioh-2-review"));
        games.add(new Game(3,"Animal Crossing: New Horizons", "Genre: Simulation", "Platform: Switch", "Studio: Nintendo", "Release Date: 03.20.2020", R.drawable.animalcrossing1, R.drawable.animalcrossing2, "New Horizons sees the player assuming the role of a customizable character who moves to a deserted island after purchasing a deserted island package from Tom Nook, a tanuki character who has appeared in every entry in the Animal Crossing series. Taking place in real-time, the player can explore the island in a nonlinear fashion, gathering and crafting items, catching insects and fish, and developing the island into a community of anthropomorphic animals.", "https://www.ign.com/articles/animal-crossing-new-horizons-review-for-switch"));
        games.add(new Game(4,"Mount & Blade II: Bannerlord", "Genre: Strategy&RPG", "Platform: PC", "Studio: TaleWorlds", "Release Date: 03.30.2020", R.drawable.mountandblade21, R.drawable.mountandblade22, "Mount & Blade II: Bannerlord is an action role-playing video game developed by TaleWorlds Entertainment. It is a prequel to Mount & Blade: Warband, a stand-alone expansion pack for the 2008 game Mount & Blade. Bannerlord takes place 210 years before its predecessor, with a setting inspired by the Migration Period.", "https://www.ign.com/articles/mount-blade-ii-bannerlord-early-access-review"));
        games.add(new Game(5,"Resident Evil 3: Remake", "Genre: Horror&Action", "Platform: PS4, XB1, PC", "Studio: Capcom", "Release Date: 04.03.2020", R.drawable.residentevil31, R.drawable.residentevil32, "Resident Evil 3 is a survival horror game developed and published by Capcom. It is a remake of Resident Evil 3: Nemesis and follows Jill Valentine and Carlos Oliveira as they attempt to survive a zombie apocalypse while hunted by the intelligent bioweapon Nemesis.", "https://www.ign.com/articles/resident-evil-3-final-review"));
        games.add(new Game(6,"Final Fantasy VII: Remake", "Genre: RPG", "Platform: PS4", "Studio: Square Enix", "Release Date: 04.10.2020", R.drawable.finalfantasy71, R.drawable.finalfantasy72, "Final Fantasy VII Remake is a remake of the 1997 PlayStation game Final Fantasy VII. Players control mercenary Cloud Strife as he and an eco-terrorist group known as AVALANCHE oppose the Shinra Electric Power Company, a powerful megacorporation, from using the planet's life essence as an energy source. The gameplay combines real-time action with strategic and role-playing elements.", "https://www.ign.com/articles/final-fantasy-7-remake-review"));
        games.add(new Game(7,"Ghost of Tsushima", "Genre: Action Adventure", "Platform: PS4", "Studio: Sucker Punch", "Release Date: 06.26.2020", R.drawable.ghostoftsushima1, R.drawable.ghostoftsushima2, "Ghost of Tsushima is an upcoming action-adventure game developed by Sucker Punch Productions and published by Sony Interactive Entertainment for PlayStation 4. Featuring an open world for players to explore, it revolves around Jin Sakai, one of the last samurai on Tsushima Island during the first Mongol invasion of Japan in the 1270s.", "https://www.ign.com/articles/ghost-of-tsushima-sucker-punch-ps4-preview-details"));
        games.add(new Game(8,"Marvel's The Avengers", "Genre: Action", "Platform: PS4, XB1, PC", "Studio: Square Enix", "Release Date: 09.04.2020", R.drawable.marvelsavengers1, R.drawable.marvelsavengers2, "Marvel's Avengers is an upcoming action-adventure video game developed by Crystal Dynamics and Eidos Montréal and published by Square Enix. Based on the Marvel Comics superhero team the Avengers, the game is inspired by the long-running comic book mythology and adaptations in other media.", "https://www.ign.com/articles/marvels-avengers-release-date-collectors-edition"));
        games.add(new Game(9,"Cyberpunk 2077", "Genre: RPG", "Platform: PS4, XB1, PC", "Studio: CD Projekt Red", "Release Date: 09.17.2020", R.drawable.cyberpunk20771, R.drawable.cyberpunk20772, "Adapted from the Cyberpunk franchise, it takes place in dystopian Night City, an open world with six distinct regions. Players assume the role of the customisable mercenary V in a first-person perspective, acquiring skills in hacking and machinery, an arsenal of ranged weapons, and options for melee combat. Both lethal and non-lethal playthroughs are possible.", "https://www.ign.com/articles/cyberpunk-2077-will-be-around-for-a-long-time-unlocked-439"));
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Home:
                Toast.makeText(this,"This is the homepage", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Wishlist:
                Intent i = new Intent(this, WishList_Activity.class);
                startActivity(i);
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
