/*
* File Name: DrawingModule.java
* Written by: Xiaoran Du
* Description: To implement the features for drawing different shapes by dragging the mouses.
*                  Revision History
* Date:                   By:               Action:
* -------------------------------------------------------
 04/08/2023             xd     Created the DrawingModule java class.
*/

package com.project.xda4;

import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class DrawingModule{
    //create a drawing pane
    Pane drawingPane = new Pane();
    PenSizeModule penSizeModule = new PenSizeModule();
    ShapeColorModule shapeColorModule = new ShapeColorModule();
    ShapeModule shapeModule = new ShapeModule();
    //coordinates
    double startX, startY, endX, endY;
    //for rectangle and square

    //getDrawing method
    public DrawingModule getDrawing() {
        DrawingModule drawingModule = new DrawingModule();
        drawingPane.setStyle("-fx-background-color: white");
        drawingPane.setPadding(new Insets(5, 5, 5, 5));
        drawingPane.setPrefSize(500, 900);
        return drawingModule;
    }

    //drawing controllers
    public void drawingController(ShapeModule shapeModule, PenSizeModule penSizeModule, ShapeColorModule shapeColorModule) {
        drawingPane.setOnMousePressed (e -> {
            //get the start point coordination
            startX = e.getX();
            startY = e.getY();

        });

        drawingPane.setOnMouseReleased(e -> {
            //get the end point coordination
            endX = e.getX();
            endY = e.getY();

            //for rectangle, sqaure
            double width = Math.abs(endX - startX);
            double height = Math.abs(endY - startY);
            //for circle
            double circleRadius = Math.sqrt((endX - startX) * (endX - startX) + (endY - startY) * (endY - startY));
            //for oval
            double ovalRadiusX = Math.abs(endX - startX);
            double ovalRadiusY = Math.abs(endY - startY);

            //try-catch statement, to catch the exception if the mouse moved out of the drawing pane boundary
            try {
                if (isValid(startX, startY, endX, endY)) {
                    //draw the rectangle
                    if (shapeModule.shape.getValue().equals("Rectangle")) {
                        drawingPane.getChildren().add(shapeModule.drawRect(startX, startY, width, height, shapeColorModule.getBrushColor(), shapeColorModule.getFilledinColor(), penSizeModule.getSize()));
                        //draw the circle
                    } else if (shapeModule.shape.getValue().equals("Circle")) {
                        try {
                            if (isValidCircle(startX, startY, circleRadius))
                                drawingPane.getChildren().add(shapeModule.drawCircle(startX, startY, circleRadius, shapeColorModule.getBrushColor(), shapeColorModule.getFilledinColor(), penSizeModule.getSize()));
                        } catch (OutOfBoundaryException ex) {
                            System.out.println(ex.getMessage());
                        }
                        //draw the square
                    } else if (shapeModule.shape.getValue().equals("Square")) {
                        drawingPane.getChildren().add(shapeModule.drawSquare(startX, startY, width, shapeColorModule.getBrushColor(), shapeColorModule.getFilledinColor(), penSizeModule.getSize()));
                        //draw the oval
                    } else if (shapeModule.shape.getValue().equals("Oval")) {
                        try {
                            if (isValidOval(startX, startY, ovalRadiusX, ovalRadiusY))
                                drawingPane.getChildren().add(shapeModule.drawOval(startX, startY, ovalRadiusX, ovalRadiusY, shapeColorModule.getBrushColor(), shapeColorModule.getFilledinColor(), penSizeModule.getSize()));
                        } catch (OutOfBoundaryException ex) {
                            System.out.println(ex.getMessage());
                        }
                        //draw the line
                    } else if (shapeModule.shape.getValue().equals("Line")) {
                        drawingPane.getChildren().add(shapeModule.drawLine(startX, startY, endX, endY, shapeColorModule.getBrushColor(), shapeColorModule.getFilledinColor(), penSizeModule.getSize()));
                    }
                }
                ;
            } catch (OutOfBoundaryException ex) {
                System.out.println(ex.getMessage());
            }

        });
    }

    //isValid method
    public boolean isValid(double startX, double startY, double endX, double endY) throws OutOfBoundaryException{
        boolean isValid = true;
        if (startX < 0 || startY < 0 || endX < 0 || endY < 0) {
            throw new OutOfBoundaryException("Your drawing is out of the drawing pad.");
        }

        return isValid;
    }

    //isValid for circle
    public boolean isValidCircle (double startX, double startY, double radius) throws OutOfBoundaryException {
        boolean isValid = true;
        if (startX -radius < 0 || startY - radius < 0) {
            throw new OutOfBoundaryException("Your drawing is out of the drawing pad.");
        }

        return isValid;
    }


    //isValid for oval
    public boolean isValidOval (double startX, double startY, double ovalRadiusX, double ovalRadiusY) throws OutOfBoundaryException {
        boolean isValid = true;
        if (startX - ovalRadiusX < 0 || startY - ovalRadiusY < 0) {
            throw new OutOfBoundaryException("Your drawing is out of the drawing pad.");
        }

        return isValid;
    }

}
