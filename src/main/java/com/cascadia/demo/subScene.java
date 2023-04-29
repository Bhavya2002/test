/*
Group Number 32
Student Names and GitHub IDs:
    Bhavya Bhatia 29760014
    Mayank Sehrawat 87071103
 */
package com.cascadia.demo;

import com.gameView.GameViewLauncher;
import com.gameView.startingTiles;
import com.gameView.wildLifeScoringCards;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//SubScene for to enter Name of Players
public class subScene extends SubScene {
    public AnchorPane root2;
    public ArrayList<Player> list;
    public static HashMap<Integer, Player> Store;
    public Buttons B1, B2, B3, B4;
    public TextField T1, T2, T3, T4;
    public Player p1, p2, p3, p4;

    public subScene() {
        super(new AnchorPane(), 900, 1150);
        root2 = (AnchorPane) this.getRoot();
        BackgroundFill backColor = new BackgroundFill(Color.TRANSPARENT, null, null);
        root2.setBackground(new Background(backColor));
        root2.setLayoutY(700);
        root2.setLayoutX(0);
    }
    // Function to move subscene into the scene called when button "let's Go" is pressed
    public void moveSubScene() {
        TranslateTransition up = new TranslateTransition();
        up.setDuration(Duration.seconds(1));
        up.setNode(this);
        up.setToY(-450);
        up.play();
    }
    //Adding Button to the pane "root2"
    public void createButton_P(Buttons b1, Integer y) {
        b1.setLayoutX(600);
        b1.setLayoutY(y);
        root2.getChildren().add(b1);
    }
    // Defining function of button which is to create Player and setName which is entered in the text box
    public void buttonCommand(Buttons B, TextField T, Player P, ArrayList<Player> list) {
        B.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                P.setName(T.getText());
                if(!nameExists(P)){
                    list.add(P);
                }
                else{
                    System.out.println("Error");
                }
            }
        });
    }
    //Defining Label function
    private void Label_P(String text, Integer y){
        Label Lb1 = new Label(text);
        Lb1.setLayoutX(350);
        Lb1.setLayoutY(y);
        root2.getChildren().add(Lb1);
    }
    //Defining TextField Function
    public void Input_P(TextField Player_T, Integer y) {
        Player_T.setLayoutX(430);
        Player_T.setLayoutY(y);
        root2.getChildren().add(Player_T);
    }
    //Number of Buttons,Labels,
    public void Player_Name(int Num_Player) {
        startingTiles st1 = new startingTiles();

        list = new ArrayList<>();
        //Labels for Number of Players Entered
        for (int i = 1; i <= Num_Player; i++){
            Label_P("Player"+i+"_Name ",i*100);
        }
        // Defining and adding Players,Buttons,Input TextBox for respective number of players
        if (Num_Player == 2) {

            p1 = new Player();
            T1 = new TextField();
            Input_P(T1, 100);
            T2 = new TextField();
            Input_P(T2, 200);
            B1 = new Buttons("Enter");
            createButton_P(B1, 100);
            buttonCommand(B1,T1,p1,list);
            p2 =new Player();
            B2 = new Buttons("Enter");
            createButton_P(B2, 200);
            buttonCommand(B2,T2,p2,list);
        }

        if (Num_Player == 3) {

            T1 = new TextField();
            Input_P(T1, 100);
            T2 = new TextField();
            Input_P(T2, 200);
            T3 = new TextField();
            Input_P(T3, 300);
            p1 = new Player();
            B1 = new Buttons("Enter");
            createButton_P(B1, 100);
            buttonCommand(B1, T1, p1, list);
            p2 = new Player();
            B2 = new Buttons("Enter");
            createButton_P(B2, 200);
            buttonCommand(B2, T2, p2, list);
            p3 = new Player();
            B3 = new Buttons("Enter");
            createButton_P(B3, 300);
            buttonCommand(B3, T3, p3, list);
        }

        if (Num_Player == 4) {

            T1 = new TextField();
            Input_P(T1, 100);
            T2 = new TextField();
            Input_P(T2, 200);
            T3 = new TextField();
            Input_P(T3, 300);
            T4 = new TextField();
            Input_P(T4, 400);
            p1 = new Player();
            B1 = new Buttons("Enter");
            createButton_P(B1, 100);
            buttonCommand(B1, T1, p1, list);
            p2 = new Player();
            B2 = new Buttons("Enter");
            createButton_P(B2, 200);
            buttonCommand(B2, T2, p2, list);
            p3 = new Player();
            B3 = new Buttons("Enter");
            createButton_P(B3, 300);
            buttonCommand(B3, T3, p3, list);
            p4 = new Player();
            B4 = new Buttons("Enter");
            createButton_P(B4, 400);
            buttonCommand(B4, T4, p4, list);
        }
    }

    public boolean nameExists(Player p){
        for(int i=0; i< list.size(); i++){
            if(list.get(0).getName().equalsIgnoreCase(p.getName())){
                return true;
            }
        }
        return false;
    }
    //Button to Randomise order of players and calling Game View Launcher
    public void buttonContinue() {
        Buttons cont = new Buttons("Continue");
        cont.setLayoutX(690);
        cont.setLayoutY(250);
        root2.getChildren().add(cont);
        cont.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Store = play_order(list);
                GameViewLauncher view = new GameViewLauncher();

                for (int i = 1; i <= Store.size(); i++) {
                    System.out.println(Store.get(i).getName());
                }
                wildLifeScoringCards scoringCards = new wildLifeScoringCards();
            }
        });
    }

    //Function to randomise order of play
    public HashMap<Integer, Player> play_order(ArrayList<Player> l){
        Random rand = new Random();
        Store = new HashMap<>();
        int size = l.size();

        for (int i = 0; i < size; i++){

            int randomIndex = rand.nextInt(l.size());
            Store.put(i + 1, l.get(randomIndex));
            l.remove(randomIndex);
        }
        setOrderedPlayer(Store);
        return Store;
    }
    public static void setOrderedPlayer(HashMap<Integer, Player> store){
        Store = store;
    }

    public static HashMap<Integer, Player> getOrderedPlayer() {
        return Store;
    }
}