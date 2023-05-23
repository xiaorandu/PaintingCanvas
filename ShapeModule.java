/*
* File Name: ShapeModule.java
* Written by: Xiaoran Du
* Description: To implement the features of selecting different shapes to draw.
*                  Revision History
* Date:                   By:               Action:
* -------------------------------------------------------
 04/08/2023             xd     Created the ShapeModule java class.
*/

package com.project.xda4;

import javafx.scene.control.ComboBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ShapeModule {
    //create a combo box storing different shapes
    ComboBox<String> shape = new ComboBox<>();

    //getShape method
    public ShapeModule getShape() {
        ShapeModule shapeModule = new ShapeModule();
        shape.setPrefSize(200, 5);
        shape.setValue("Circle");
        shape.getItems().addAll(
                "Circle",
                "Oval",
                "Rectangle",
                "Square",
                "Line"
        );

        return shapeModule;
    }

    //draw rectangle
    public Rectangle drawRect(double startX, double startY, double width, double height, Paint brushcolor, Paint filledinColor, double penSize) {
        Rectangle rect = new Rectangle(startX, startY, width, height);
        rect.setStrokeWidth(penSize);
        rect.setStroke(brushcolor);
        rect.setFill(filledinColor);
        return rect;
    }

    //draw color
    public Circle drawCircle(double startX, double startY, double radius, Paint brushcolor, Paint filledinColor, double penSize) {
        Circle circle = new Circle(startX, startY, radius);
        circle.setStrokeWidth(penSize);
        circle.setStroke(brushcolor);
        circle.setFill(filledinColor);
        return circle;
    }

    //drawn square
    public Rectangle drawSquare(double startX, double startY, double width, Paint brushcolor, Paint filledinColor, double penSize) {
        Rectangle square = new Rectangle(startX, startY, width, width);
        square.setStrokeWidth(penSize);
        square.setStroke(brushcolor);
        square.setFill(filledinColor);
        return square;
    }

    //draw oval
    public Ellipse drawOval(double startX, double startY, double ovalRadiusX, double ovalRadiusY, Paint brushcolor, Paint filledinColor, double penSize) {
        Ellipse oval = new Ellipse(startX, startY, ovalRadiusX, ovalRadiusY);
        oval.setStrokeWidth(penSize);
        oval.setStroke(brushcolor);
        oval.setFill(filledinColor);
        return oval;
    }

    //draw line
    public Line drawLine(double startX, double startY, double endX, double endY, Paint brushcolor, Paint filledinColor, double penSize) {
        Line line = new Line(startX, startY, endX, endY);
        line.setStrokeWidth(penSize);
        line.setStroke(brushcolor);
        line.setFill(filledinColor);
        return line;
    }
}
