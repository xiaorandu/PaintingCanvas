/*
* File Name: CoordinationModule.java
* Written by: Xiaoran Du
* Description: To implement the features of showing the mouse coordination.
*                  Revision History
* Date:                   By:               Action:
* -------------------------------------------------------
 04/08/2023             xd     Created the CoordinationModule java class.
*/


package com.project.xda4;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CoordinationModule {
    HBox paneForCoordination = new HBox();

    //label to display coordinates
    Label labelMouseMove = new Label("Mouse move: ");

    //getCoordination method
    public CoordinationModule getCoordination() {
        CoordinationModule coordinationModule = new CoordinationModule();
        paneForCoordination.getChildren().add(labelMouseMove);
        return coordinationModule;
    }

    //event controller for showing the coordination
    public void coordinationController(DrawingModule drawingModule) {
        Text coordinationDisplay = new Text();
        drawingModule.drawingPane.setOnMouseMoved(e ->{
            String msg = "[" + e.getX() + ", " + e.getY() + "]";
            coordinationDisplay.setText(msg);
            paneForCoordination.getChildren().add(coordinationDisplay);
        });
    }
}
