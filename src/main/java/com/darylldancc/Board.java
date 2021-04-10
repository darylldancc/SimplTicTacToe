package com.darylldancc;

import java.util.Arrays;

public class Board {

    // Stores the characters of the board
    private String[] cells;


    // Used for checking purposes
    private String[] x;
    private String[] o;

    // Used for main game
    public Board() {

        cells = new String[]{"s", " ", " ", " ", " ", " ", " ", " ", " ", " "};

        // For checking
        x = new String[] {"X", "X", "X"};
        o = new String[] {"O", "O", "O"};
    }

    // Prints the board with the values of cells
    public void printBoard() {

        System.out.println("+=============+");
        System.out.println("||¹" +cells[1]+ " |²" +cells[2] + " |³" + cells[3] + " ||");
        System.out.println("||---+---+---||");
        System.out.println("||⁴" +cells[4]+ " |⁵" +cells[5] + " |⁶" + cells[6] + " ||");
        System.out.println("||---|---|---||");
        System.out.println("||⁷" +cells[7]+ " |⁸" +cells[8] + " |⁹" + cells[9] + " ||");
        System.out.println("+=============+");

    }

    public boolean setX(int index) {

        if (cells[index].equals(" ")) {
            cells[index] = "X";
            // Will return a successful value set
            return true;
        }
        // Will not register the move since the cell is already populated
        return false;

    }

    public boolean setO(int index) {

        if (cells[index].equals(" ")) {
            cells[index] = "O";
            // Will return a successful value set
            return true;
        }
        // Will not register the move since the cell is already populated
        return false;

    }

    public boolean checkForX() {

        // List of the cells that will be checked
        String[] d1 = {cells[1] , cells[5], cells[9]};
        String[] d2 = {cells[3] , cells[5], cells[7]};
        String[] v1 = {cells[1] , cells[4], cells[7]};
        String[] v2 = {cells[2] , cells[5], cells[8]};
        String[] v3 = {cells[3] , cells[6], cells[9]};
        String[] h1 = Arrays.copyOfRange(cells, 1, 4);
        String[] h2 = Arrays.copyOfRange(cells, 4, 7);
        String[] h3 = Arrays.copyOfRange(cells, 7, 10);

        // Checks if any of the array chunks matches the "x" array
        if (Arrays.deepEquals(d1, x)) {
            return true;
        } else if (Arrays.deepEquals(d2, x)) {
            return true;
        } else if (Arrays.deepEquals(v1, x)) {
            return true;
        } else if (Arrays.deepEquals(v2, x)) {
            return true;
        } else if (Arrays.deepEquals(v3, x)) {
            return true;
        } else if (Arrays.deepEquals(h1, x)) {
            return true;
        } else if (Arrays.deepEquals(h2, x)) {
            return true;
        } else if (Arrays.deepEquals(h3, x)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkForO() {

        // List of the cells that will be checked
        String[] d1 = {cells[1] , cells[5], cells[9]};
        String[] d2 = {cells[3] , cells[5], cells[7]};
        String[] v1 = {cells[1] , cells[4], cells[7]};
        String[] v2 = {cells[2] , cells[5], cells[8]};
        String[] v3 = {cells[3] , cells[6], cells[9]};
        String[] h1 = Arrays.copyOfRange(cells, 1, 4);
        String[] h2 = Arrays.copyOfRange(cells, 4, 7);
        String[] h3 = Arrays.copyOfRange(cells, 7, 10);

        // Checks if any of the array chunks matches the "o" array
        if (Arrays.deepEquals(d1, o)) {
            return true;
        } else if (Arrays.deepEquals(d2, o)) {
            return true;
        } else if (Arrays.deepEquals(v1, o)) {
            return true;
        } else if (Arrays.deepEquals(v2, o)) {
            return true;
        } else if (Arrays.deepEquals(v3, o)) {
            return true;
        } else if (Arrays.deepEquals(h1, o)) {
            return true;
        } else if (Arrays.deepEquals(h2, o)) {
            return true;
        } else if (Arrays.deepEquals(h3, o)) {
            return true;
        } else {
            return false;
        }

    }

}


