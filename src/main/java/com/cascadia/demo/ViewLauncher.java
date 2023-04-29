/*
Group Number 32
Student Names and GitHub IDs:
    Bhavya Bhatia 29760014
    Mayank Sehrawat 87071103
 */
package com.cascadia.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class ViewLauncher {
    //define Pane
    private AnchorPane Anch_mainPane;
    //define Scene
    private Scene mainScene;
    public static Stage primaryStage;
    public subScene sub1;
    public TextField Num_Player_T;
    private Image backGround;
    private Label Lb1;

    private static final int width = 900;
    private static final int height = 700;

    public int Num_Player;

    public ViewLauncher() {
        Anch_mainPane = new AnchorPane();
        mainScene = new Scene(Anch_mainPane,width,height);
        primaryStage = new Stage();
        primaryStage.setScene(mainScene);
        //BackGround image of mainScene
        backGround = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/META-INF/BackGroundCover.png")));

        BackgroundFill backImage = new BackgroundFill(new ImagePattern(backGround),null,null);
        Anch_mainPane.setBackground(new Background(backImage));

        //Adding statring buttons, Lables,Input box to the Pane
        createButton();
        Label("Enter number of Players (2-4)");
        Input();
        //Adding subScence to the Pane
        Name_subScence();


    }
    public void Name_subScence() {
        sub1 = new subScene();

        Anch_mainPane.getChildren().add(sub1);

    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }

    //Creating Button and setting action of button when pressed
    public void createButton(){

        Buttons B1 = new Buttons("Lets Go");
        Anch_mainPane.getChildren().add(B1);
        //Layout of Button
        B1.setLayoutX(600);
        B1.setLayoutY(148);
        //Function when  button pressed
        B1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setNum_Player(Num_Player_T);
                if (getNum_Player() <= 4 && getNum_Player() >= 2){
                    Anch_mainPane.getChildren().remove(Lb1);
                    sub1.Player_Name(getNum_Player());
                    sub1.buttonContinue();
                    sub1.moveSubScene();
                }
                //Error Handling for number of players allowed
                else {
                    Lb1 = new Label("Wrong input!!");
                    Lb1.setLayoutX(450);
                    Lb1.setLayoutY(200);
                    Anch_mainPane.getChildren().add(Lb1);
                }
            }
        });


    }
    // Creating Label
    private void Label(String text){
        Label Lb1 = new Label(text);
        Lb1.setLayoutX(250);
        Lb1.setLayoutY(152);
        Anch_mainPane.getChildren().add(Lb1);

    }
    //Creating Input Box
    private void Input(){
        Num_Player_T = new TextField();
        Num_Player_T.setLayoutX(430);
        Num_Player_T.setLayoutY(150);
        Anch_mainPane.getChildren().add(Num_Player_T);

    }

    public void setNum_Player(TextField Num_test){
        this.Num_Player = Integer.parseInt(Num_test.getText());
    }
    public Integer getNum_Player(){
        return Num_Player;
    }


}