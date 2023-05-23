/*
* File Name: ButtonModule.java
* Written by: Xiaoran Du
* Description: To implement the features of the undo, clear and exit buttons.
*                  Revision History
* Date:                   By:               Action:
* -------------------------------------------------------
 04/08/2023             xd     Created the ButtonModule java class.
*/

package com.project.xda4;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ButtonModule {
    //create a VBox for buttons
    VBox paneForButtons = new VBox();

    //create buttons
    Button buttonUndo = new Button("Undo");
    Button buttonClear = new Button("Clear");
    Button buttonExit = new Button("Exit");

    //getButton method
    public ButtonModule getButtons() {
        //set spacing and sizes of buttons
        ButtonModule buttonModule = new ButtonModule();
        paneForButtons.setSpacing(8);
        buttonUndo.setPrefSize(150,5);
        buttonClear.setPrefSize(150,5);
        buttonExit.setPrefSize(150,5);

        paneForButtons.getChildren().addAll(buttonUndo, buttonClear, buttonExit);
        return buttonModule;
    }

    //event controllers for the three buttons
    public void buttonController(PenSizeModule penSizeModule, ShapeColorModule shapeColorModule,
                                 BackgroundColorModule backgroundColorModule, DrawingModule drawingModule, ShapeModule shapeModule,
                                Stage stage) {
        //handle events for the undo button
        buttonUndo.setOnAction(e -> {
            int count = drawingModule.drawingPane.getChildren().size();
            if (count > 0){drawingModule.drawingPane.getChildren().remove(count - 1);}});

        //handle events for the clear button
        buttonClear.setOnAction(e -> {
            //set combobox to the default
            shapeModule.shape.setValue("Circle");

            penSizeModule.buttonMedium.setSelected(true);
            penSizeModule.buttonSmall.setSelected(false);
            penSizeModule.buttonLarge.setSelected(false);

            //default slider setting
            shapeColorModule.sliderR.setValue(0);
            shapeColorModule.sliderG.setValue(0);
            shapeColorModule.sliderB.setValue(0);
            shapeColorModule.sliderA.setValue(1);

            //set checkbox to the default
            backgroundColorModule.buttonWhite.setSelected(true);
            backgroundColorModule.buttonLightGray.setSelected(false);
            backgroundColorModule.buttonCoral.setSelected(false);
            backgroundColorModule.buttonLightCyan.setSelected(false);
            backgroundColorModule.buttonBeige.setSelected(false);
            shapeColorModule.filledColor.setSelected(false);
            drawingModule.drawingPane.setStyle("-fx-background-color: white");
            drawingModule.drawingPane.getChildren().clear();

            //set the shape color to the default
            shapeColorModule.filledColor.setSelected(false);
            shapeColorModule.setBrushColor(Color.BLACK);
            shapeColorModule.setFilledinColor(Color.TRANSPARENT);

        });

        //handle events for the exit button
        buttonExit.setOnAction(e ->stage.close());
    }
}
