/*
* File Name: ShapeColorModule.java
* Written by: Xiaoran Du
* Description: To implement the features of changing the colors of the stroke and the fill color of the shape.
*                  Revision History
* Date:                   By:               Action:
* -------------------------------------------------------
 04/08/2023             xd     Created the ShapeColorModule java class.
*/

package com.project.xda4;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ShapeColorModule {
    private Paint filledinColor;
    private Paint brushColor;

    //for color selections
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    //create HBox for slider groups;
    HBox sliderGroup = new HBox();

    //create VBox for each of color info
    VBox sliderInfoR = new VBox();
    VBox sliderInfoG = new VBox();
    VBox sliderInfoB = new VBox();
    VBox sliderInfoA = new VBox();

    //create the label for each of the color info
    Label labelR = new Label("R");
    Label labelG = new Label("G");
    Label labelB = new Label("B");
    Label labelA = new Label("A");

    //create the slider for each of the color info
    Slider sliderR = new Slider(0, 255, 0);
    Slider sliderG = new Slider(0, 255, 0);
    Slider sliderB = new Slider(0, 255, 0);
    Slider sliderA = new Slider(0, 1, 1);


    //create the textfield to show each of the color info
    TextField textR = new TextField(Double.toString(sliderR.getValue()));
    TextField textG = new TextField(Double.toString(sliderG.getValue()));
    TextField textB = new TextField(Double.toString(sliderB.getValue()));
    TextField textA = new TextField(Double.toString(sliderA.getValue()));


    //create a checkbox for filled color option
    CheckBox filledColor = new CheckBox("Filled Color");

    //create a VBox for titlePane and sliders and checkbox
    VBox paneForShapeColor = new VBox();

    //create a titledPane for shape color
    TitledPane tPaneColor = new TitledPane("Drawing Shape Color", sliderGroup);

    public Paint getBrushColor() {
        return brushColor;
    }

    public void setBrushColor(Paint brushColor) {
        this.brushColor = brushColor;
    }

    public void setFilledinColor(Paint filledinColor) {
        this.filledinColor = filledinColor;
    }

    public Paint getFilledinColor() {
        return filledinColor;
    }

    //getShapeColor method
    public ShapeColorModule getShapeColor() {
        ShapeColorModule shapeColorModule = new ShapeColorModule();
        sliderR.setOrientation(Orientation.VERTICAL);
        sliderG.setOrientation(Orientation.VERTICAL);
        sliderB.setOrientation(Orientation.VERTICAL);
        sliderA.setOrientation(Orientation.VERTICAL);

        sliderInfoR.getChildren().addAll(labelR, sliderR, textR);
        sliderInfoG.getChildren().addAll(labelG, sliderG, textG);
        sliderInfoB.getChildren().addAll(labelB, sliderB, textB);
        sliderInfoA.getChildren().addAll(labelA, sliderA, textA);

        sliderGroup.getChildren().addAll(sliderInfoR, sliderInfoG, sliderInfoB, sliderInfoA);
        paneForShapeColor.getChildren().addAll(tPaneColor, sliderGroup, filledColor);

        filledColor.setPadding(new Insets(0, 0, 0, 10));
        paneForShapeColor.setSpacing(5);
        paneForShapeColor.setPrefSize(200, 250);
        paneForShapeColor.setSpacing(8);
        sliderGroup.setSpacing(8);

        return shapeColorModule;
    }

    //event controller for shapeColor
    public void shapeColorController() {
        //property-to-property bindings for textfields and sliders
        textR.textProperty().bind(sliderR.valueProperty().asString("%.0f"));
        textG.textProperty().bind(sliderG.valueProperty().asString("%.0f"));
        textB.textProperty().bind(sliderB.valueProperty().asString("%.0f"));
        textA.textProperty().bind(sliderA.valueProperty().asString("%.1f"));

        //listeners that set shape's fill and stroke based on slider changes
        sliderR.valueProperty().addListener((observableValue, old_val, new_val) -> {
            red = new_val.intValue();
            brushColor = Color.rgb(red, green, blue, alpha);
            if (filledColor.isSelected()) filledinColor = brushColor;
        });

        sliderG.valueProperty().addListener((observableValue, old_val, new_val) -> {
            green = new_val.intValue();
            brushColor = Color.rgb(red, green, blue, alpha);
            if (filledColor.isSelected()) filledinColor = brushColor;
        });

        sliderB.valueProperty().addListener((observableValue, old_val, new_val) -> {
            blue = new_val.intValue();
            brushColor = Color.rgb(red, green, blue, alpha);
            if (filledColor.isSelected()) filledinColor = brushColor;
        });

        sliderA.valueProperty().addListener((observableValue, old_val, new_val) -> {
            alpha = new_val.doubleValue();
            brushColor = Color.rgb(red, green, blue, alpha);
            if (filledColor.isSelected()) filledinColor = brushColor;
        });

        //handle events for checkBox
        filledColor.setOnAction(e -> {
            if (filledColor.isSelected()) {
                filledinColor = getBrushColor();
            } else {
                filledinColor = Color.TRANSPARENT;
            }
        });
    }
}