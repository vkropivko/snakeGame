package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;

public class Apple {
    private Color color = Color.GREEN;
    private Color color2 = Color.WHITE;
    private int xShift = 5;
    private int yShift = 5;
    public static final int CANVAS_X = 1200;
    public static final int CANVAS_Y = 720;
    private GraphicsContext gc;
    private double x;
    private double y;
    Random rand = new Random();

    public static int getCanvasX() {
        return CANVAS_X;
    }

    public static int getCanvasY() {
        return CANVAS_Y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Apple(GraphicsContext gc) {
        this.gc = gc;
        draw();

    }

    public void initApple(GraphicsContext gc) {
        int x = rand.nextInt(40);
        int y = rand.nextInt(24);
        this.x = x * 30;
        this.y = y * 30;
        this.gc = gc;
        draw();

    }

    public int checkApple(List<Snake> list, GraphicsContext gc) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getX() == this.getX() && list.get(i).getY() == this.getY()) {
                initApple(gc);
            }
        }

        return 0;
    }

    public void draw() {

        gc.setFill(color);
        gc.fillOval(x, y, 30, 30);
        gc.setFill(color2);
        gc.fillOval(x + (30 / 2), y + (30 / 2), 30 / 3, 30 / 3);
    }


    public void clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    public double getDistance() {
        return Math.sqrt(Math.pow(this.getX() - getX(), 2) +
                Math.pow(this.getY() - getY(), 2));
    }


}
