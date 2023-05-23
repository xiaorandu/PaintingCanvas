/*
* File Name: PainterApp.java
* Written by: Xiaoran Du
* Description: I use javaFX codes to enable the users to specify the drawing characteristics including drawing shape, stroke color, fill color,
* pen size, background color, and mouse coordination. Users can position and size each of the shape by dragging the mouse. Users can also undo the last shape drawn
* or choose to clear all the drawings. For each of the above features, I use a Java class to implement it. The seperated modules make the code easy to read and
* the overall organization clear. Other files that are included in this packages are BackgroundColorModule.java, ButtonModule.java, CoordinationModule.java,
* DrawingModule.java, OutofBoundaryException.java, PenSize.java, PenSizeModule.java, ShapeColorModule.java, and ShapeModule.java.


package com.project.xda4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PainterApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BackgroundColorModule backgroundColorModule = new BackgroundColorModule();//create a backgroundColorModule instance
        PenSizeModule penSizeModule = new PenSizeModule();//create a penSizeModule instance
        ShapeColorModule shapeColorModule = new ShapeColorModule();//create a shapeColorModule instance
        ButtonModule buttonModule = new ButtonModule();//create a buttonModule instance
        DrawingModule drawingModule = new DrawingModule();//create a drawingModule instance
        ShapeModule shapeModule = new ShapeModule();//create a shapeModule instance
        CoordinationModule coordinationModule = new CoordinationModule();//create a coordinationModule instance

        shapeColorModule.getShapeColor();//get the shapeColorModule object
        backgroundColorModule.getBackgroundColor(); //get the backgroundColorModule object
        penSizeModule.getPenSize();//get the penSizeModule object
        buttonModule.getButtons();//get the buttonModule object
        drawingModule.getDrawing();//get the drawingModule object
        coordinationModule.getCoordination();//get the coordinationModule object
        shapeModule.getShape();//get the shapeModule object

        BorderPane pane = new BorderPane();  //create a pane for the overall layout
        pane.setLeft(getSideBar(shapeModule.shape, shapeColorModule.paneForShapeColor, backgroundColorModule.paneForBackgroundColor,
                penSizeModule.paneForPenSize, buttonModule.paneForButtons, coordinationModule.paneForCoordination));
        pane.setCenter(drawingModule.drawingPane);

        //call the event controllers for each of the modules
        backgroundColorModule.backgroundColorController(drawingModule.drawingPane);
        shapeColorModule.shapeColorController();
        buttonModule.buttonController(penSizeModule, shapeColorModule, backgroundColorModule, drawingModule, shapeModule, stage);
        drawingModule.drawingController(shapeModule, penSizeModule, shapeColorModule);
        penSizeModule.penSizeController();
        coordinationModule.coordinationController(drawingModule);

        Scene scene = new Scene(pane, 800, 700); //scene contains all the contents of a scene graph

        stage.setTitle("Painter"); //set the stage title
        stage.setScene(scene); //attach the scene to the stage
        stage.show(); //display the content of the stage
    }

    //method to get the sidebar elements
    private VBox getSideBar(ComboBox<String> shape, VBox paneForShapeColor, VBox paneForBackgroundColor,
                            VBox paneForPenSize, VBox paneForButtons, HBox paneForCoordination) {
        //create the sidebar
        VBox sideBar = new VBox();
        sideBar.getChildren().addAll(shape, paneForShapeColor, paneForBackgroundColor,
                paneForPenSize, paneForButtons, paneForCoordination);
        sideBar.setSpacing(15);
        sideBar.setPadding(new Insets(5, 5, 5, 5));
        return sideBar;
    }

    public static void main(String[] args) {
        launch(); //launch the application
    }
}