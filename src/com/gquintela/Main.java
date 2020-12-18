package com.gquintela;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Sudoku Solver!!");

        int[][] board = {
                {0, 6, 0, 0, 0, 4, 3, 0, 8},
                {3, 0, 0, 0, 0, 0, 5, 0, 0},
                {8, 0, 0, 0, 0, 2, 1, 9, 0},
                {2, 0, 0, 6, 0, 0, 0, 0, 0},
                {0, 4, 0, 9, 3, 0, 7, 0, 2},
                {6, 0, 8, 0, 0, 0, 0, 3, 0},
                {0, 0, 6, 4, 0, 0, 2, 7, 5},
                {4, 5, 0, 0, 9, 0, 0, 0, 0},
                {7, 0, 0, 0, 2, 0, 9, 0, 0}
        };

        int[][] solvedBoard = {
                {5, 6, 9, 7, 1, 4, 3, 2, 8},
                {3, 2, 1, 8, 6, 9, 5, 4, 7},
                {8, 7, 4, 3, 5, 2, 1, 9, 6},
                {2, 3, 7, 6, 4, 1, 8, 5, 9},
                {1, 4, 5, 9, 3, 8, 7, 6, 2},
                {6, 9, 8, 2, 7, 5, 4, 3, 1},
                {9, 1, 6, 4, 8, 3, 2, 7, 5},
                {4, 5, 2, 1, 9, 7, 6, 8, 3},
                {7, 8, 3, 5, 2, 6, 9, 1, 4}
        };

        Sudoku sudoku = new Sudoku(board);
        sudoku.printSudoku();
    }
}
