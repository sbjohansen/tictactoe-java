package com.tictactoe;
import java.awt.*;
import java.awt.event.*;

public class Board {
    public static final int squareSize = 200;
    private Square[][] board;
    private Square winner;
    private TicTacToeLogic ticTacToeLogic;
    private String currentTurn;
    private int rows, cols, movesMade;
    private boolean winnerFound;
    private String playerChoice;

    public Board() {
        board = new Square[3][3];
        ticTacToeLogic = new TicTacToeLogic();
        rows = board.length;
        cols = board[0].length;
        currentTurn = " ";
        winner = null;
        winnerFound = false;
        movesMade = 0;
        playerChoice = "";
    }

    public void update(){};

    public void draw(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 180));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == null)
                    board[i][j] = new Square();

                    g.setColor(Color.WHITE);
                    g.fillRect(i*squareSize + 100, j*squareSize + 90, squareSize, squareSize);
                    ((Graphics2D)g).setStroke(new BasicStroke(4));
                    g.setColor(Color.BLACK);
                    g.drawRect(i*squareSize + 100, j*squareSize + 90, squareSize + 1, squareSize + 1);
                    g.drawString(board[i][j].getPiece().getValue(), i*squareSize + 95+(squareSize/5), j*squareSize + 160+(squareSize/2));

                }
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString(String.valueOf("Welcome to Tic Tac Toe!"), 50, 60);
        }

}
