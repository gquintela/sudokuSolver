package com.gquintela;

import java.awt.Point;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    //fields
    private final int[][] board;

    //constructor
    public Sudoku(int[][] numbers) {
        board = numbers;
    }

    //public methods
    public boolean solve() {
        Point position = nextEmpty();
        if (position.x == -1) {
            return true;
        }
        for (int i = 1; i < 10; i++) {
            setNumber(i, position.x, position.y);
            if (isValid(position.x, position.y)) {
                if (solve()) {
                    return true;
                }
                setNumber(0, position.x, position.y);

            }
        }
        setNumber(0, position.x, position.y);
        return false;
    }

    public void printSudoku() {
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0) {
                System.out.print(" ----------------------------- \n");
            }
            System.out.print("|");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(" " + board[i][j] + " ");

                if (j % 3 == 2) {
                    System.out.print("|");
                }
            }
            System.out.print("\n");
        }
        System.out.print(" ----------------------------- \n");
    }

    public void setNumber(int n, int x, int y) {
        board[x][y] = n;
    }
    
    public void writeToFile(String filename) throws IOException {
        String parsedFilename = "puzzles/" + "SOLVED_" + filename;
        File myfile = new File(parsedFilename);

        FileWriter myWriter = new FileWriter(parsedFilename);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                    myWriter.write(board[i][j] + " ");
            }
            myWriter.write("\n");
        }
        System.out.println("\nSuccessfully wrote the answer to the file " + parsedFilename);
        myWriter.close();
    }

    //Private methods

    //O(|line|) if size is a variable, O(1) for constant 3x3 sudoku
    private boolean isRowOK(int row) {
        Set<Integer> tmpSet = new HashSet<>();
        for (int i : board[row]) {
            if (tmpSet.contains(i)) return false;
            if (i != 0) {
                tmpSet.add(i);
            }
        }
        return true;
    }

    //O(|line|) if size is a variable, O(1) for constant 3x3 sudoku
    private boolean isColumnOK(int column) {
        Set<Integer> tmpSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if (tmpSet.contains(board[i][column])) return false;
            if (board[i][column] != 0) {
                tmpSet.add(board[i][column]);
            }
        }
        return true;
    }

    //    O(1)
    private boolean isSquareOK(int x, int y) {
        Set<Integer> tmpSet = new HashSet<>();
        int iStart = (x / 3) * 3;
        for (int i = iStart; i < iStart + 3; i++) {
            int jStart = (y / 3) * 3;
            for (int j = jStart; j < jStart + 3; j++) {
                if (tmpSet.contains(board[i][j])) return false;
                if (board[i][j] != 0) {
                    tmpSet.add(board[i][j]);
                }
            }
        }
        return true;
    }

    private boolean isValid(int x, int y) {
        return isRowOK(x) && isColumnOK(y) && isSquareOK(x, y);
    }

    private Point nextEmpty() {
        Point coordinate = new Point();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    coordinate.x = i;
                    coordinate.y = j;
                    return coordinate;
                }
            }
        }
        coordinate.x = -1;
        coordinate.y = -1;
        return coordinate;
    }

}
