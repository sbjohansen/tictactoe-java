package com.tictactoe;
import java.util.Scanner;

public class TicTacToeGame {
    private Scanner scanner;
    private String[][] board;
    private String player1, player2;
    private int movesMade;
    private int rows, cols;

    public TicTacToeGame() {
        scanner = new Scanner(System.in);
        board = new String[3][3];
        player1 = "O";
        player2 = "X";
        movesMade = 0;
        rows = board.length;
        cols = board[0].length;
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.run();
    }

    public void run() {
        System.out.println("Welcome to Tic Tac Toe!");
        String input = player1;
        String playAgain = "";
        boolean gameOver = false;
        setUpBoard();
        do {
            updateBoard();
            makeMove(input);
            input = changeTurn(input);
            if(movesMade == 9 && winnder().equals("Draw")) {
                updateBoard();
                System.out.println("Draw");
                playAgain = resetGame();
            } else if(winnder().equals(player1)) {
                updateBoard();
                System.out.println(player1 + " wins!");
                playAgain = resetGame();
            }
            if(playAgain.equalsIgnoreCase("No")){
                gameOver = true;
            } else if(playAgain.equalsIgnoreCase("Yes")){
                movesMade = 0;
                playAgain = "";
                setUpBoard();
                input = player1;
            }
        } while (!gameOver);

    }

    private void setUpBoard() {
        System.out.println("Welcome to Tic Tac Toe!");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = " ";
            }
            System.out.println();
        }
        System.out.println();
    }

    public void updateBoard() {
        System.out.println("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("[ " + board[i][j] + " ]");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    public void makeMove(String move) {
        boolean moveMade = false;
        int playerRow = 0, playerCol = 0;
        do {
            System.out.println("Player with \'" + move + "\' enter a row number between 1 and " + (rows));
            playerRow = scanner.nextInt();
            System.out.println("Player with \'" + move + "\' enter a column number between 1 and " + (cols));
            playerCol = scanner.nextInt();

            if (playerRow >= 1 && playerRow <= rows && playerCol >= 1 && playerCol <= cols) {
                if (board[playerRow - 1][playerCol - 1].equals(" ")) {
                    board[playerRow - 1][playerCol - 1] = move;
                    moveMade = true;
                    movesMade++;
                } else {
                    System.out.println("That spot is already taken. Please choose another.");
                }
            }
        } while (!moveMade);
    }

    public String changeTurn(String turn) {
        if (turn.equals(player1)) {
            return player2;
        } else {
            return player1;
        }
    }

    public String winnder() {
        // check rows
        for (int i = 0; i < rows; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                return board[i][0];
            }
        }
        // check columns
        for (int i = 0; i < cols; i++) {
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])) {
                return board[0][i];
            }
        }
        // check diagonals
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            return board[0][0];
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            return board[0][2];
        }
        return "Draw";
    }

    public String resetGame() {
        String statusCall = " ";
        do {
            System.out.println("Do you want to play again? (Yes/No)");
            statusCall = scanner.next();
        } while (!statusCall.equalsIgnoreCase("Yes") &&!statusCall.equalsIgnoreCase("No"));
        return statusCall;
    }
}




