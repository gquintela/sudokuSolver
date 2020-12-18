package com.gquintela;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    //fields
    private int[][] board;

    //constructor
    public Sudoku(int[][] numbers) {
        board = numbers;
    }

    //public methods
    public void solve() {
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

    //Private methods

    //O(|line|) if size is a variable, O(1) for constant 3x3 sudoku
    private boolean isRowOK(int row){
        Set<Integer> tmpSet = new HashSet<Integer>();
        for (int i : board[row])
        {
            if (tmpSet.contains(i)) return false;
            tmpSet.add(i);
        }
        return true;
    }

    //O(|line|) if size is a variable, O(1) for constant 3x3 sudoku
    private boolean isColumnOK(int column){
        Set<Integer> tmpSet = new HashSet<Integer>();
        for (int i = 0; i < board.length; i++) {
            if (tmpSet.contains(board[i][column])) return false;
            tmpSet.add(i);
        }
        return true;
    }

    private boolean isSquareOK(){
        return false;
    }

    private boolean isValidBoard(){
        return false;
    }

}
