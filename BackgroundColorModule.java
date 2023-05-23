/*
* File Name: BackgroundColorModule.java
* Written by: Xiaoran Du
* Description: To implement the feature of changing the colors of the background of the drawing pane.
*                  Revision History
* Date:                   By:               Action:
* -------------------------------------------------------
 04/08/2023             xd     Created the BackgroundColorModule java class.
*/


package com.project.xda4;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class BackgroundColorModule {

    //create radioButtons for the colors
    RadioButton buttonWhite = new RadioButton("WHITE");
    RadioButton buttonLightGray = new RadioButton("LIGHT GRAY");
    RadioButton buttonCoral = new RadioButton("CORAL");
    RadioButton buttonLightCyan = new RadioButton("LIGHT CYAN");
    RadioButton buttonBeige = new RadioButton("BEIGE");

    RadioButton[] rbsForBackgroundColor= {buttonWhite, buttonLightGray, buttonCoral, buttonLightCyan, buttonBeige};
    //create the toggle group for radio buttons
    ToggleGroup groupRadioButtonsBackground = new ToggleGroup();

    //create a VBox for radio buttons
    VBox paneForRadioButtonsBackground = new VBox();

    //create a Vbox for background color group
    VBox paneForBackgroundColor = new VBox();

    //create a titlePane for background color
    TitledPane tPaneBackground = new TitledPane("Board Background Color", paneForRadioButtonsBackground);


    //getBackgroundColor method
    public BackgroundColorModule getBackgroundColor() {
        BackgroundColorModule backgroundColorModule = new BackgroundColorModule();
        //set the spacings
        paneForRadioButtonsBackground.setSpacing(5);

        paneForBackgroundColor.getChildren().addAll(tPaneBackground, paneForRadioButtonsBackground);

        for (RadioButton rb: rbsForBackgroundColor) {
            paneForRadioButtonsBackground.getChildren().add(rb);
        }

        buttonWhite.setSelected(true);//default selected
        //add the buttons to the toggle group
        buttonWhite.setToggleGroup(groupRadioButtonsBackground);
        buttonLightGray.setToggleGroup(groupRadioButtonsBackground);
        buttonCoral.setToggleGroup(groupRadioButtonsBackground);
        buttonLightCyan.setToggleGroup(groupRadioButtonsBackground);
        buttonBeige.setToggleGroup(groupRadioButtonsBackground);

        //set radio buttons to the default
        buttonWhite.setSelected(true);
        buttonLightGray.setSelected(false);
        buttonCoral.setSelected(false);
        buttonLightCyan.setSelected(false);
        buttonBeige.setSelected(false);

        return backgroundColorModule;
    }

    //event controller for the background color radioButtons
    public void backgroundColorController(Pane drawingPane){

        buttonWhite.setOnAction(e -> {if(buttonWhite.isSelected()) {drawingPane.setStyle("-fx-background-color: white");}});
        buttonLightGray.setOnAction(e -> {if(buttonLightGray.isSelected()) {drawingPane.setStyle("-fx-background-color: lightgray");}});
        buttonCoral.setOnAction(e -> {if(buttonCoral.isSelected()) {drawingPane.setStyle("-fx-background-color: coral");}});
        buttonLightCyan.setOnAction(e -> {if(buttonLightCyan.isSelected()) {drawingPane.setStyle("-fx-background-color: lightcyan");}});
        buttonBeige.setOnAction(e -> {if(buttonBeige.isSelected()) {drawingPane.setStyle("-fx-background-color: beige");}});
    }
}
