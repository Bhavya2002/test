/*
Group Number 32
Student Names and GitHub IDs:
    Bhavya Bhatia 29760014
    Mayank Sehrawat 87071103
 */
package com.cascadia.demo;

import com.gameView.Hex_subScene;
import com.gameView.wildlife_Tokens;

//Player class to Store Details specific to each player
public class Player {
    public String Name;
    public Hex_subScene grid;
    public  wildlife_Tokens[][] wildlifeArray;
    public int numOfNatureToken;

    public void setNumOfNatureToken(int numOfNatureToken) {
        this.numOfNatureToken = numOfNatureToken;
    }

    public int getNumOfNatureToken() {
        return numOfNatureToken;
    }

    public void setGrid(Hex_subScene grid) {
        this.grid = grid;
    }

    public Hex_subScene getGrid() {
        return grid;
    }

    public Player(){
        //Hex Grid instance for player
        grid = new Hex_subScene();
        setGrid(grid);
        // 2D array of wildlifes on players hex grid
        wildlifeArray = new wildlife_Tokens[grid.rows][grid.cols];
        setNumOfNatureToken(0);
    }

    public void setName(String S){
        Name = S;
    }

    public String getName(){
        return Name;
    }

}
