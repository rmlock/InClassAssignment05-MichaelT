package com.example.miket.inclassassignment05_michaelt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText playerInputNumber = null;
    EditText playerInputName = null;
    EditText playerInputNote = null;
    String nameInput;
    int numberInput;
    boolean validNumber = false;
    boolean validName = false;

    ArrayList<Player> playerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String key = getString(R.string.saved_username);

        SharedPreferences sharedPreference = getPreferences(MODE_PRIVATE);
        String coachName = sharedPreference.getString(key, getString(R.string.saved_username_default));

        TextView usernameDisplay = (TextView) findViewById(R.id.usernameDisplayed);
        usernameDisplay.setText("Welcome " + coachName);

    }

    public void setCoachName(View view) {
        EditText editText = (EditText) findViewById(R.id.coachNameEntering);
        String coachName = editText.getText().toString();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.saved_username), coachName);
        editor.commit();
        TextView usernameDisplay = (TextView) findViewById(R.id.usernameDisplayed);
        usernameDisplay.setText("Welcome " + coachName);

    }

    public void clear_button(View view) {
        playerInputName = (EditText) findViewById(R.id.player_name_edittext);
        playerInputNumber = (EditText) findViewById(R.id.player_number_edittext);
        playerInputNote = (EditText) findViewById(R.id.player_note_edittext);

        playerInputName.setText(null);
        playerInputNumber.setText(null);
        playerInputNote.setText(null);
        validName = false;
        validNumber = false;


        Toast t = Toast.makeText(this, "Form Cleared", Toast.LENGTH_SHORT);
        t.show();
    }


    public void savePlayerInfo(View view) {
        EditText playerInputName = (EditText) findViewById(R.id.player_name_edittext);
        if (!playerInputName.getText().toString().isEmpty()) {
            nameInput = playerInputName.getText().toString();
            validName = true;
        }

        EditText playerInputNumber = (EditText) findViewById(R.id.player_number_edittext);
        if (!playerInputNumber.getText().toString().isEmpty()) {
            numberInput = Integer.parseInt(playerInputNumber.getText().toString());
            validNumber = true;
        }

        EditText playerInputNote = (EditText) findViewById(R.id.player_note_edittext);
        String noteInput = "";
        if (playerInputNote.getText().toString().isEmpty()) {
            noteInput = "No additional notes";
        } else {
            noteInput = playerInputNote.getText().toString();
        }
        if (!validName || !validNumber) {

            Toast e = Toast.makeText(this, "You are missing the name or the player number- check again", Toast.LENGTH_SHORT);
            e.show();

        } else {
            Player p = new Player(nameInput, numberInput, noteInput);
            playerList.add(p);
            playerInputName.setText(null);
            playerInputNumber.setText(null);
            playerInputNote.setText(null);
            validName = false;
            validNumber = false;

            Toast t = Toast.makeText(this, "Player Information Saved", Toast.LENGTH_SHORT);
            t.show();


        }


    }

    public void seeRoster(View view) {
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Player List", playerList);
        startActivity(intent);
    }


}