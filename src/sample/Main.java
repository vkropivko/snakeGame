package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    public int fieldSize = 30;
    public int fieldX = CANVAS_X / fieldSize;
    public int fieldY = CANVAS_Y / fieldSize;
    public static final int CANVAS_X = 1200;
    public static final int CANVAS_Y = 720;
    private GraphicsContext gc;
    private Snake snake;
    private Snake snake2;
    private Apple apple;
    Timer timer;
    private List<Snake> list;
    private int index;
    private Snake temp;
    private double tempX;
    private double tempY;
    private KeyCode lastKeyCode;
    private Field[][] fields = new Field[fieldX][fieldY];
    private boolean canGame = true;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Snake");
        final Canvas canvas = new Canvas(CANVAS_X, CANVAS_Y);
        final BorderPane group = new BorderPane(canvas);
        final Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        gc = canvas.getGraphicsContext2D();
        snake = new Snake(0, 30, gc);
        snake2 = new Snake(0, 0, gc);
        apple = new Apple(gc);
        snake.draw();
        apple.initApple(gc);
        list = new ArrayList<Snake>();
        list.add(snake2);
        list.add(snake);
        index = list.size() - 1;

        registerOnKeyPresseedListener(scene);

        startTimerAndProgramm(scene);

    }

    @Override
    public void stop() throws Exception {
        timer.cancel();
    }

    public void registerOnKeyPresseedListener(final Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                  @Override
                                  public void handle(KeyEvent event) {
                                      if (canGame) {
                                          move(event.getCode());
                                          lastKeyCode = event.getCode();

                                      }
                                  }

                              }

        );
    }

    private void move(KeyCode code) {

        switch (code) {
            case DOWN:

                snake.clear();
                drawField();
                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i).moveControl() == 0) {
                        gameOver();
                    }
                    list.get(i).draw();
                }

                if (list.get(index).getDistance(apple) < 30) {
                    if (Snake.checkSnake(list, gc) == true) {
                        gameOver();

                    }

                    apple.initApple(gc);
                    System.out.println("NEW APPLEEEE ");
                    System.out.println(apple.getX());
                    System.out.println(apple.getY());
                    apple.checkApple(list, gc);
                    tempX = list.get(index).getX();
                    tempY = list.get(index).getY();
                    temp = new Snake(tempX, tempY + 30, gc);
                    list.add(temp);
                    index = list.size() - 1;
                    System.out.println("DOWN ADD " + tempX + " " + tempY);


                } else {
                    if (Snake.checkSnake(list, gc) == true) {
                        gameOver();

                    }

                    tempX = list.get(index).getX();
                    tempY = list.get(index).getY();
                    temp = new Snake(tempX, tempY + 30, gc);
                    list.add(temp);
                    list.remove(0);

                    System.out.println("DOWN " + tempX + " " + tempY);

                }
                apple.draw();


                break;
            case UP:

                snake.clear();
                drawField();
                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i).moveControl() == 0) {
                        gameOver();
                    }
                    list.get(i).draw();
                }

                if (list.get(index).getDistance(apple) < 30) {
                    if (Snake.checkSnake(list, gc) == true) {
                        gameOver();

                    }

                    apple.initApple(gc);
                    System.out.println("NEW APPLEEEE ");
                    System.out.println(apple.getX());
                    System.out.println(apple.getY());
                    apple.checkApple(list, gc);
                    tempX = list.get(index).getX();
                    tempY = list.get(index).getY();
                    temp = new Snake(tempX, tempY - 30, gc);
                    list.add(temp);
                    index = list.size() - 1;
                    System.out.println("UP ADD " + tempX + " " + tempY);


                } else {
                    if (Snake.checkSnake(list, gc) == true) {
                        gameOver();

                    }

                    tempX = list.get(index).getX();
                    tempY = list.get(index).getY();
                    temp = new Snake(tempX, tempY - 30, gc);
                    list.add(temp);
                    list.remove(0);


                    System.out.println("UP  " + tempX + " " + tempY);

                }

                apple.draw();


                break;

            case LEFT:

                snake.clear();
                drawField();
                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i).moveControl() == 0) {
                        gameOver();
                    }
                    list.get(i).draw();
                }
                if (list.get(index).getDistance(apple) < 30) {

                    if (Snake.checkSnake(list, gc) == true) {
                        gameOver();

                    }

                    apple.initApple(gc);
                    System.out.println("NEW APPLEEEE ");
                    System.out.println(apple.getX());
                    System.out.println(apple.getY());
                    apple.checkApple(list, gc);
                    tempX = list.get(index).getX();
                    tempY = list.get(index).getY();
                    temp = new Snake(tempX - 30, tempY, gc);
                    list.add(temp);
                    index = list.size() - 1;
                    System.out.println("LEFT ADD " + tempX + " " + tempY);


                } else {

                    if (Snake.checkSnake(list, gc) == true) {
                        gameOver();

                    }
                    tempX = list.get(index).getX();
                    tempY = list.get(index).getY();
                    temp = new Snake(tempX - 30, tempY, gc);
                    list.add(temp);
                    list.remove(0);

                    System.out.println("LEFT  " + tempX + " " + tempY);

                }
                apple.draw();


                break;
            case RIGHT:

                snake.clear();
                drawField();

                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i).moveControl() == 0) {
                        gameOver();
                    }
                    list.get(i).draw();
                }

                if (list.get(index).getDistance(apple) < 30) {
                    if (Snake.checkSnake(list, gc) == true) {
                        gameOver();

                    }

                    apple.initApple(gc);
                    System.out.println("NEW APPLEEEE ");
                    System.out.println(apple.getX());
                    System.out.println(apple.getY());
                    apple.checkApple(list, gc);
                    tempX = list.get(index).getX();
                    tempY = list.get(index).getY();
                    temp = new Snake(tempX + 30, tempY, gc);
                    list.add(temp);
                    index = list.size() - 1;
                    System.out.println("RIGHT ADD " + tempX + " " + tempY);


                } else {

                    if (Snake.checkSnake(list, gc) == true) {
                        gameOver();

                    }
                    tempX = list.get(index).getX();
                    tempY = list.get(index).getY();
                    temp = new Snake(tempX + 30, tempY, gc);
                    list.add(temp);
                    list.remove(0);
                    System.out.println("RIGHT " + tempX + " " + tempY);

                }

                apple.draw();


                break;
            case N:

                timer.cancel();
                apple.draw();
                list.get(index).draw();
                break;
        }


    }

    public void delete() {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(0))) {
                list.removeAll(list.subList(i, list.size()));
            }
        }
    }

    public void gameOver() {
        System.out.println("Game Over ");
        double fontSize = 200.0;
        gc.setFont(new Font(fontSize));
        gc.fillText("Game Over \n " + "Your result " + index + " ", 0, 350, 1200);

        timer.cancel();
        apple.draw();
        drawField();
        canGame = false;
        list.get(index).draw();


    }

    public void addField() {
        int x = 0;
        int y = 0;

        for (int i = 0; i < fieldX; i++) {

            y = 0;
            for (int j = 0; j < fieldY; j++) {

                fields[i][j] = new Field(x, y, gc);


                y = y + 30;

            }
            x = x + 30;

        }
    }

    public void drawField() {
        for (int i = 0; i < fieldX; i++) {

            for (int j = 0; j < fieldY; j++) {

                fields[i][j].draw();
            }
        }
    }


    public void startTimerAndProgramm(final Scene scene) {


        addField();


        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                runOnGuiThread();
            }

            private void runOnGuiThread() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {


                        if (lastKeyCode != null) {

                            move(lastKeyCode);
                        }


                    }


                });


            }
        };

        timer.schedule(task, 200, 150);


    }


    public static void main(String[] args) {
        launch(args);

    }
}


