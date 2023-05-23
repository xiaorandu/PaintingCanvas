/*
* File Name: PenSizeModule.java
* Written by: Xiaoran Du
* Description: To implement the features of changing the sizes of the stroke.
*                  Revision History
* Date:                   By:               Action:
* -------------------------------------------------------
 04/08/2023             xd     Created the PenSizeModule java class.
*/

package com.project.xda4;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class PenSizeModule {
    //create a VBox for pen size
    VBox paneForPenSize = new VBox();

    //create a VBox for radio buttons
    VBox paneForRadioButtons = new VBox();

    //create a titledPane for pen size
    TitledPane tPaneSize = new TitledPane("Pen Size", paneForRadioButtons);
    private int size = PenSize.MEDIUM.getPenSize();

    //create three radioButtons
    RadioButton buttonSmall = new RadioButton("Small (2px)");
    RadioButton buttonMedium = new RadioButton("Medium (4px)");
    RadioButton buttonLarge = new RadioButton("Large (6px)");

    //create the toggle group for radio buttons
    ToggleGroup groupRadioButtons = new ToggleGroup();

    public int getSize() {
        return size;
    }

    //getPenSize method
    public PenSizeModule getPenSize() {
        PenSizeModule penSizeModule = new PenSizeModule();
        //set spacings for the pen size buttons
        paneForPenSize.setSpacing(8);
        paneForRadioButtons.setSpacing(5);
        paneForRadioButtons.getChildren().addAll(buttonSmall, buttonMedium, buttonLarge);
        paneForPenSize.getChildren().addAll(tPaneSize, paneForRadioButtons);

        buttonMedium.setSelected(true);//default selected
        buttonSmall.setToggleGroup(groupRadioButtons);
        buttonMedium.setToggleGroup(groupRadioButtons);
        buttonLarge.setToggleGroup(groupRadioButtons);

        return penSizeModule;
    }

    //event controllers for the pen size radioButtons
    public void penSizeController() {
        buttonSmall.setOnAction(e -> {
            if (buttonSmall.isSelected()) {
                size = PenSize.SMALL.getPenSize();
            }
        });
        buttonMedium.setOnAction(e -> {
            if (buttonMedium.isSelected()) {
                size = PenSize.MEDIUM.getPenSize();
            }
        });
        buttonLarge.setOnAction(e -> {
            if (buttonLarge.isSelected()) {
                size = PenSize.LARGE.getPenSize();
            }
        });
    }

}
