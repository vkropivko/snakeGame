package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Field {

    public static final int CANVAS_X = 1200;
    public static final int CANVAS_Y = 720;
    private int x = 0;
    private int y = 0;
    private GraphicsContext gc;


    public Field(int x, int y, GraphicsContext gc) {
        this.x = x;
        this.y = y;
        this.gc = gc;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }


    public void draw() {
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, 30, 30);

    }


}
