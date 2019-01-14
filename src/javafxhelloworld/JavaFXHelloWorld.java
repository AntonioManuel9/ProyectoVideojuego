/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxhelloworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author Antonio Manuel
 */
public class JavaFXHelloWorld extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane ();
        Scene scene = new Scene (root, 600, 400, Color.BLACK);
        primaryStage.setTitle("Videojuego");
        primaryStage.setScene(scene);
        primaryStage.show();  
        
        Ellipse ellipse = new Ellipse(); {
            ellipse.setCenterX(150.0f);
            ellipse.setCenterY(100.0f);
            ellipse.setRadiusX(45.0f);
            ellipse.setRadiusY(10.0f);
            ellipse.setFill(Color.YELLOW);
            root.getChildren().add(ellipse);
        }
        Polygon polygonAla1 = new Polygon(new double[]{
            130.0, 75.0,
            180.0, 100.0,
            145.0, 100.0
        });
        polygonAla1.setFill(Color.YELLOW);
        root.getChildren().add(polygonAla1);
        Polygon polygonAla2 = new Polygon(new double[]{
            130.0, 140.0,
            180.0, 100.0,
            145.0, 100.0
        });
        polygonAla2.setFill(Color.YELLOW);
        root.getChildren().add(polygonAla2);
        Polygon polygonAlaTrasera = new Polygon(new double[]{
            110.0, 85.0,
            110.0, 95.0,
            120.0, 95.0
        });
        polygonAlaTrasera.setFill(Color.YELLOW);
        root.getChildren().add(polygonAlaTrasera);
    }
}