package com.gquintela;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length != 1){
            System.out.println("Please add the input file name as a parameter.");
            return;
        }

        System.out.println("Welcome to the Sudoku Solver!\n");

        int[][] board = new int[9][9];

        ///read file
        try {
            File myFile = new File("puzzles/" + args[0]);
            Scanner myReader = new Scanner(myFile);
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] numbers = data.split(" ");
                int j = 0;
                for (String number: numbers) {
                    board[i][j] = parseInt(number);
                    j++;
                }
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. Does the input file exist?");
            e.printStackTrace();
            return;
        }

        Sudoku sudoku = new Sudoku(board);
        try {
            System.out.println("Requested sudoku to be solved:\n");
            sudoku.printSudoku();
        }catch (Error e){
            System.out.println("Error, please check your input file.");
        }

        sudoku.solve();
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("Solved sudoku:\n");
        sudoku.printSudoku();
        sudoku.writeToFile(args[0]);
    }
}
