/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.antoniomanuelramirez.videojuego;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author Antonio Manuel
 */
public class JavaFXHelloWorld extends Application {
    
    Pane root;
    ImageView obstaculo1;
    ImageView obstaculo2;
    ImageView obstaculo3;
    ImageView Score;
    int posicionFondo1 = 0;
    int posicionFondo2 = 600;
    int velocidad = -3;
    int AvionCurrentSpeed = 0;
    Scene scene;
    Group groupAvion = new Group();
    Group groupObs1 = new Group();
    Group groupObs2 = new Group();
    Ellipse cuerpo = new Ellipse();
    int posAvionX = 100;
    int posicionAleatoria;
    int obstaculo1X = 650;
    int obstaculo2X = 680;
    Random random = new Random();
    Polygon polygonAla1 = new Polygon(new double[]{
            130.0, 75.0,
            180.0, 100.0,
            145.0, 100.0
    });
    Polygon polygonAla2 = new Polygon(new double[]{
            130.0, 140.0,
            175.0, 100.0,
            145.0, 100.0
    });
    Rectangle colisionObs1 = new Rectangle(obstaculo1X, 170, 40, 150);
    Rectangle colisionObs2 = new Rectangle(obstaculo2X, 145, 40, 150);
    public void avion() {
        // Cuerpo del avión
        cuerpo = new Ellipse(); {
            cuerpo.setCenterX(150.0f);
            cuerpo.setCenterY(100.0f);
            cuerpo.setRadiusX(45.0f);
            cuerpo.setRadiusY(10.0f);
            cuerpo.setFill(Color.BLACK);
            groupAvion.getChildren().add(cuerpo);
        }
        // Color del primer Ala
        polygonAla1.setFill(Color.BLACK);
        groupAvion.getChildren().add(polygonAla1);
        
        // Color del segundo Ala
        polygonAla2.setFill(Color.BLACK);
        groupAvion.getChildren().add(polygonAla2);
        // Creacion de la parte trasera
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
        // Elipse para la ventana del avion.
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
        groupAvion.setScaleX(1.0);
        groupAvion.setScaleY(1.0);
    }
    public void obstaculos(){
        Image image1 = new Image ("/es/antoniomanuelramirez/videojuego/images/Sprite_04.png");
        Image image2 = new Image ("/es/antoniomanuelramirez/videojuego/images/Sprite_01.png");
        // Obstaculo 1
        obstaculo1 = new ImageView();
        obstaculo1.setImage(image1);
        obstaculo1.setFitWidth(100);
        obstaculo1.setFitHeight(150);
        obstaculo1.setY(170);
        obstaculo1.setX(obstaculo1X);
        // Grupo para juntar la imagen del arbol y el rectangulo de la colision
        groupObs1.getChildren().add(colisionObs1);
        groupObs1.getChildren().add(obstaculo1);
        root.getChildren().add(groupObs1);
        colisionObs1.setVisible(false);
        // Obstaculo 2
        obstaculo2 = new ImageView();
        obstaculo2.setImage(image2);
        obstaculo2.setFitWidth(90);
        obstaculo2.setFitHeight(185);
        obstaculo2.setY(145);
        obstaculo2.setX(obstaculo2X);
        // Grupo para juntar la imagen del arbol y el rectangulo de la colision
        groupObs2.getChildren().add(colisionObs2);
        groupObs2.getChildren().add(obstaculo2);
        root.getChildren().add(groupObs2);
        colisionObs2.setVisible(false);
        
        posicionAleatoria = random.nextInt(500);    
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
        // Rectangulos para la colision del avion
        Rectangle colisionAbajo = new Rectangle(0, 265, 600, 100 );
        Rectangle colisionArriba = new Rectangle(0, 10, 600, 10);
        colisionObs1 = new Rectangle(obstaculo1X+45, 170, 20, 150);
        colisionObs2 = new Rectangle(obstaculo2X+45, 145, 20, 150);
        root.getChildren().add(colisionObs1);
        root.getChildren().add(colisionObs2);
       
        AnimationTimer movimiento = new AnimationTimer(){
            @Override
            public void handle(long now){
//                System.out.println(obstaculo2X);
                System.out.println(obstaculo1X);
                fondo1.setX(posicionFondo1);
                fondo2.setX(posicionFondo2);
                // Movimiento del fondo
                posicionFondo1+=velocidad;
                posicionFondo2+=velocidad;
                // Movimiento de los obstaculos
                obstaculo1X+=velocidad;
                obstaculo2X+=velocidad;
                // Velocidad para la colision de los obstaculos
//                Establecesmos la posicion de los obstaculos
                groupObs1.setLayoutX(obstaculo1X);
                groupObs2.setLayoutX(obstaculo2X + posicionAleatoria);
                if (posicionFondo2 == 0){
                    posicionFondo1=600;
                }
                if (posicionFondo1 == 0){
                    posicionFondo2 = 600;
                }
                if(obstaculo1X <= -800){
                    int distancia = random.nextInt(500);
                    obstaculo1X = obstaculo2X + distancia;
                }
                if(obstaculo2X <= -800){
                    int distancia = random.nextInt(500);
                    obstaculo2X = obstaculo1X + distancia;
                }
                posAvionX += AvionCurrentSpeed;
                groupAvion.setLayoutY(posAvionX);
                // Creacion de la colision.
                // Colision con el suelo
                Shape shapeColision = Shape.intersect(polygonAla1, colisionAbajo);
                boolean colisionVacia = shapeColision.getBoundsInLocal().isEmpty();
                // Colision con la parte superior de la pantalla
                Shape shapeColision2 = Shape.intersect(polygonAla2, colisionArriba);
                boolean colisionVacia2 = shapeColision2.getBoundsInLocal().isEmpty();
                // Colision con el primer obstaculo
                Shape shapeColision3 = Shape.intersect(cuerpo, colisionObs1);
                boolean colisionVacia3 = shapeColision3.getBoundsInLocal().isEmpty();
                // Colision con el segundo obstaculo
                Shape shapeColision4 = Shape.intersect(cuerpo, colisionObs2);
                boolean colisionVacia4 = shapeColision4.getBoundsInLocal().isEmpty();
                if (colisionVacia == false){
                    reiniciar();
                    velocidad = 0;
                }
                if (colisionVacia2 == false){
                    reiniciar();
                    velocidad = 0;
                }
                if (colisionVacia3 == false){
                    reiniciar();
                    velocidad = 0;
                }
                if (colisionVacia4 == false){
                    reiniciar();
                    velocidad = 0;
                }
            };
        };
        movimiento.start();
    }
    public void puntuacion() {
        // Letras del Score y posicion.
        Image image3 = new Image ("/es/antoniomanuelramirez/videojuego/images/Puntuacion.png");
        Score = new ImageView();
        Score.setImage(image3);
        Score.setX(-40);
        Score.setY(-100);
        Score.setFitHeight(300);
        Score.setFitWidth(200);
        root.getChildren().add(Score);
    }
    public void reiniciar(){
        posAvionX = 100;
        posicionFondo1 = 0;
        posicionFondo2 = 600;
        obstaculo1X = 650;
        obstaculo2X = 680;
    }
    @Override
    public void start(Stage primaryStage) {
        root = new Pane ();
        scene = new Scene (root, 600, 400);
        primaryStage.setTitle("Videojuego");
        primaryStage.setScene(scene);
        primaryStage.show();
        // Añadimos todos los metodos creados anteriormente
        this.fondo();
        this.obstaculos();
        this.avion();
        this.puntuacion();
        // Movimiento del avion con las teclas
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()) {
                case UP:
                    AvionCurrentSpeed = -2;
                    break;
                case DOWN:
                    AvionCurrentSpeed = 2;
                    break;
                case ENTER:
                    this.reiniciar();
                    velocidad = -3;
            }
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            AvionCurrentSpeed = 0;
        });
    }
}