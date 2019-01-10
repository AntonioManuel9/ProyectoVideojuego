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
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Antonio Manuel
 */
public class JavaFXHelloWorld extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane ();
        Scene scene = new Scene (root, 600, 400, Color.PINK);
        primaryStage.setTitle("PongFX");
        primaryStage.setScene(scene);
        primaryStage.show();  
        
        Circle circleBall = new Circle(300, 200, 20);
        circleBall.setFill(Color.BLACK);
        root.getChildren().add(circleBall);
        
        Circle circleBall2 = new Circle(300, 200, 10);
        circleBall2.setFill(Color.WHITE);
        root.getChildren().add(circleBall2);
    }
}