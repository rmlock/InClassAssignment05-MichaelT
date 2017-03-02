package com.example.miket.inclassassignment05_michaelt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    private String displayMessage = "";
    private boolean imageSwitcher = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        getSupportActionBar().setTitle("Player Roster");

        Intent intent = getIntent();
        LinearLayout mainView = (LinearLayout) findViewById(R.id.mainView);

        ArrayList<Player> players = (ArrayList<Player>) intent.getSerializableExtra("Player List");

        for (int i = 0; players.size()> i; i++) {
            LinearLayout wrapper = new LinearLayout(this);
            wrapper.setOrientation(LinearLayout.VERTICAL);
            wrapper.setPadding(10, 10, 10, 10);

            wrapper.setBackgroundColor(Color.WHITE);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            layoutParams.setMargins(0, 0, 0, 15);

            wrapper.setLayoutParams(layoutParams);
            TextView playerName = new TextView(this);
            TextView playerNumber = new TextView(this);
            TextView playerNote = new TextView(this);
            ImageView icon = new ImageView(this);


            wrapper.addView(icon);
            wrapper.addView(playerName);
            wrapper.addView(playerNumber);
            wrapper.addView(playerNote);


            playerName.setText("Player: " + players.get(i).getName());
            playerName.setTextSize(20);
            playerNumber.setText("Number: " + players.get(i).getPlayerNumber());
            playerNote.setText("Additional Notes: " + '\n' + players.get(i).getNote());
            mainView.addView(wrapper);

            if (imageSwitcher) {
                icon.setImageResource(R.drawable.basketball);
                icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageSwitcher = false;
            } else {
                icon.setImageResource(R.drawable.footbal);
                icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageSwitcher = true;

            }




        }

    }
}
