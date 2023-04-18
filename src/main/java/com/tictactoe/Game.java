package com.tictactoe;
import java.awt.*;
import java.lang.Thread;
import java.lang.Runnable;
import java.awt.image.*;

public class Game extends Canvas implements Runnable {
    private Frame frame;
    private Board board;
    private boolean gameRunning;
    private Thread gameThread;


    public Game() {
        gameRunning = false;
        frame = new Frame(this);
        board = new Board();
    }
    public synchronized void start() {
        if(gameRunning) return;
        gameRunning = true;
        gameThread = new Thread(this);
        gameThread.start();

    }

    public synchronized void stopGame() {
        if(!gameRunning) return;
        gameRunning = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfUpdates = 60.0;
        double ns = 1000000000 / amountOfUpdates;
        double catchUp = 0;
        int updates = 0;
        int FPS = 0;
        long timerCheck = System.currentTimeMillis();
        while (gameRunning) {
            long now = System.nanoTime();
            catchUp += (now - lastTime) / ns;
            lastTime = now;
            while (catchUp >= 1) {
                update();
                updates++;
                catchUp--;
            }
            draw();
            FPS++;
            if (System.currentTimeMillis() - timerCheck > 1000) {
                timerCheck += 1000;
                System.out.println("Updates: " + updates + ", FPS: " + FPS);
                FPS = 0;
                updates = 0;
            }
        }
        stopGame();
    }

    public void update() {
    }

    public void draw() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        if(board != null) {
            board.draw(g);
        }
        bs.show();
        g.dispose();
    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}
