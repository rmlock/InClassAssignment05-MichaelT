package com.example.miket.inclassassignment05_michaelt;

import java.io.Serializable;


public class Player implements Serializable {

    private String name;
    private int playerNumber;
    private String note;


    public Player (String name, int playerNumber, String note) {
        this.name=name;
        this.playerNumber=playerNumber;
        this.note=note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Player name: " + name + "\nPlayer Number: " + playerNumber + "\nPlayer Note: " + note;
    }
}
