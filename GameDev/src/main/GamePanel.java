package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.print.attribute.standard.PrinterIsAcceptingJobs;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {

    private int frames = 0;
    private float xDelta = 100;
    private float yDelta = 100;
    private float xDir = 2f;
    private float yDir = 2f;
    private long lastCheck;

    private ArrayList<MyRect> rects=new ArrayList<>();

    private Color color = new Color(255, 0, 0);
    private Random random;
    private MouseInputs mouseInputs;

    public GamePanel() {
        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void spawnRect(int x, int y){
        rects.add(new MyRect(x,y));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Spawn rects
        for (MyRect rect: rects){
            rect.updateRect();
            rect.draw(g);
        }

        updateRectangle();
        g.setColor(color);
        g.fillRect((int) xDelta, (int) yDelta, 200, 50);  // (locationX, locationY, width, height)

//        frames++;
//        if (System.currentTimeMillis() - lastCheck >= 1000) {
//            lastCheck = System.currentTimeMillis();
//            System.out.println("FPS: " + frames);
//            frames = 0;
//        }

        // putting repaint() in paintComponent() makes a loop, as repaint calls the paintComponent() and then paintComponent() calls repaint()
        // but this loop is Bad, as when the panel size is small fps Spikes and when panel size is small fps drops
//        repaint();
    }

    private void updateRectangle() {
        xDelta += xDir;
        if (xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            color = getRndColor();
        }
        yDelta += yDir;
        if (xDelta > 400 || yDelta < 0) {
            yDir *= -1;
            color = getRndColor();
        }
    }

    private Color getRndColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }

    public class MyRect {
        int x, y, w, h;
        int xDir = 1, yDir = 1;
        Color color;

        public MyRect(int x, int y) {
            this.x = x;
            this.y = y;
            w = random.nextInt(50);
            h = w;
            color = newColor();
        }

        public void updateRect() {
            this.x += xDir;
            if ((x + w) > 400 || x < 0) {
                xDir *= -1;
                color = newColor();
            }
            this.y += yDir;
            if ((y + h) > 400 || y < 0) {
                yDir *= -1;
                color = newColor();
            }
        }

        private Color newColor() {
            return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillRect(x, y, w, h);
        }
    }
}
