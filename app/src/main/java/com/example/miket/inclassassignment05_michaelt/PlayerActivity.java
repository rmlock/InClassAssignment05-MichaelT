package com.example.miket.inclassassignment05_michaelt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    private String displayMessage = "";
    private String name;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        getSupportActionBar().setTitle("Plahyer Roster");

        Intent intent = getIntent();
        ArrayList<Player> players = (ArrayList<Player>) intent.getSerializableExtra("Player List");


//        ScrollView displayView = (ScrollView) findViewById(R.id.displayView);

        for (int i = 0; players.size()> i; i++) {
            String s= players.get(i).toString();
            displayMessage= displayMessage + "\n\n";
        }

    }
}
