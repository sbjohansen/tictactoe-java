package com.tictactoe;

public class Square {
    private Piece piece;
    private int row;
    private int col;

    public Square() {
        this.piece = new Piece(" ", -1, -1);
        this.row = -1;
        this.col = -1;
    }

    public Square(Piece piece, int row, int col) {
        this.piece = piece;
        this.row = row;
        this.col = col;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String toString() {
        return "[row: " + row + ", col: " + col + "]";

    }
}
