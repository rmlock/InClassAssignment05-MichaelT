package com.example.miket.inclassassignment05_michaelt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Player> playerList= new ArrayList<>();
//    private String nameInput;
//    private int numberInput;
//    private String noteInput;
//    private Player player;
//    private ArrayList<Player> playerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        playerList= new ArrayList<>();
    }


    public void savePlayerInfo(View view) {
        EditText playerInputName = (EditText) findViewById(R.id.player_name_edittext);
        String nameInput= playerInputName.getText().toString();

        EditText playerInputNumber = (EditText) findViewById(R.id.player_number_edittext);
        int numberInput = Integer.parseInt(playerInputNumber.getText().toString());

        EditText playerInputNote = (EditText) findViewById(R.id.player_note_edittext);
        String noteInput= playerInputNote.getText().toString();

        Player p = new Player(nameInput, numberInput, noteInput);
        playerList.add(p);

        playerInputName.setText(null);
        playerInputNumber.setText(null);
        playerInputNote.setText(null);

        Toast t = Toast.makeText(this, "Saved", Toast.LENGTH_SHORT);
        t.show();
    }

    public void seeRoster(View view) {
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Player List", playerList);
        startActivity(intent);
    }

}
