/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.antoniomanuelramirez.videojuego;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
    
    Pane root;
    int posicion1 = 0;
    int posicion2 = 600;
    int velocidad = -1;
    int avionCurrentSpeed = 0;
    Scene scene;
    Group groupAvion = new Group();
    int posAvionX = 100;
    
    public void avion() {
        
        Ellipse cuerpo = new Ellipse(); {
            cuerpo.setCenterX(150.0f);
            cuerpo.setCenterY(100.0f);
            cuerpo.setRadiusX(45.0f);
            cuerpo.setRadiusY(10.0f);
            cuerpo.setFill(Color.BLACK);
            groupAvion.getChildren().add(cuerpo);
        }
        Polygon polygonAla1 = new Polygon(new double[]{
            130.0, 75.0,
            180.0, 100.0,
            145.0, 100.0
        });
        polygonAla1.setFill(Color.BLACK);
        groupAvion.getChildren().add(polygonAla1);
        
        Polygon polygonAla2 = new Polygon(new double[]{
            130.0, 140.0,
            175.0, 100.0,
            145.0, 100.0
        });
        polygonAla2.setFill(Color.BLACK);
        groupAvion.getChildren().add(polygonAla2);
        
        Polygon polygonAlaTrasera = new Polygon(new double[]{
            100.0, 85.0,
            105.0, 100.0,
            120.0, 95.0
        });
        polygonAlaTrasera.setFill(Color.BLACK);
        groupAvion.getChildren().add(polygonAlaTrasera);
        
        Polygon polygonAlaTrasera1 = new Polygon(new double[]{
            100.0, 115.0,
            105.0, 100.0,
            120.0, 100.0
        });
        polygonAlaTrasera1.setFill(Color.BLACK);
        groupAvion.getChildren().add(polygonAlaTrasera1);
        
        Polygon polygonAlaTrasera2 = new Polygon(new double[]{
            110.0, 85.0,
            105.0, 100.0,
            120.0, 100.0
        });
        polygonAlaTrasera2.setFill(Color.BLACK);
        groupAvion.getChildren().add(polygonAlaTrasera2);
        
        Ellipse ventana = new Ellipse(); {
            ventana.setCenterX(185.0f);
            ventana.setCenterY(96.0f);
            ventana.setRadiusX(7.0f);
            ventana.setRadiusY(3.0f);
            ventana.setFill(Color.AQUA);
            groupAvion.getChildren().add(ventana);
        root.getChildren().add(groupAvion);
        ventana.setRotate(18);
        }
        groupAvion.setLayoutY(80);
        groupAvion.setScaleX(1.1);
        groupAvion.setScaleY(1.1);
    }
    public void fondo(){
        Image image = new Image("/es/antoniomanuelramirez/videojuego/images/background_land.png");
        ImageView fondo1 = new ImageView(); 
        ImageView fondo2 = new ImageView();
        fondo1.setImage(image);
        fondo2.setImage(image);
        fondo1.setFitWidth(600);
        fondo1.setFitHeight(400);
        fondo2.setFitWidth(600);
        fondo2.setFitHeight(400);
        root.getChildren().add(fondo1);
        root.getChildren().add(fondo2);
        AnimationTimer movimiento = new AnimationTimer(){
            @Override
            public void handle(long now){
                fondo1.setX(posicion1);
                fondo2.setX(posicion2);
                posicion1+=velocidad;
                posicion2+=velocidad;
                if (posicion2==0){
                    posicion1=600;
                }
                if (posicion1==0){
                    posicion2=600;
                }
                posAvionX += avionCurrentSpeed;
                groupAvion.setLayoutY(posAvionX);
            };
        };
        movimiento.start();
    }
    @Override
    public void start(Stage primaryStage) {
        
        root = new Pane ();
        scene = new Scene (root, 600, 400);
        primaryStage.setTitle("Videojuego");
        primaryStage.setScene(scene);
        primaryStage.show(); 
        fondo();
        avion();
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()) {
                case UP:
                    avionCurrentSpeed = -2;
                    break;
                case DOWN:
                    avionCurrentSpeed = 2;
                    break;
            }
        });
    }

}