package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;

public class Snake {


    private Color color = Color.BLUE;
    private int xShift = 5;
    private int yShift = 5;
    public static final int CANVAS_X = 1200;
    public static final int CANVAS_Y = 720;
    private GraphicsContext gc;
    private double x;
    private double y;
    Random rand = new Random();

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Snake(GraphicsContext gc) {
        this.x = 0;
        this.y = 0;
        this.gc = gc;
        draw();
    }


    public Snake(double x, double y, GraphicsContext gc) {
        this.x = x;
        this.y = y;
        this.gc = gc;
    }

    public void draw() {
        gc.setFill(color);
        gc.fillRect(x, y, 30, 30);

    }


    public static boolean checkSnake(List<Snake> list, GraphicsContext gc) {

        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i).getX() == list.get(list.size() - 1).getX() && list.get(i).getY() == list.get(list.size() - 1).getY()) {

                return true;
            }
        }
        return false;
    }


    public void clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    public int moveControl() {

        if (x > gc.getCanvas().getWidth() - 30) {


            x = gc.getCanvas().getWidth() - 30;
            return 0;


        }
        if (y > gc.getCanvas().getHeight() - 30) {


            y = gc.getCanvas().getHeight() - 30;
            return 0;

        }
        if (x < 0) {


            x = 0;
            return 0;


        }
        if (y < 0) {

            y = 0;
            return 0;

        }


        draw();
        return 1;

    }

    public double getDistance(Apple a) {
        return Math.sqrt(Math.pow(this.getX() - a.getX(), 2) +
                Math.pow(this.getY() - a.getY(), 2));
    }


}
