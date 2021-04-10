package com.darylldancc;

import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        // The main execution
        while (true) {
            read("Main Menu.txt");
            System.out.print("\nInput (1,2; 3 for exit) > ");
            String input = reader.nextLine();
            switch (input) {
                case "1":
                    play(); // Decided to make the game a method for convenience purposes
                    break;
                case "2":
                    help();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Invalid input!");
            }
        }

    }


    // Help module
    public static void help() {

        Scanner reader = new Scanner(System.in);

        while(true) {

            separator();
            read("Help.txt");
            System.out.print("\nInput (1,2,4) > ");
            String input = reader.nextLine();

            // Accesses the help file based on user input
            switch (input) {
                case "1":
                    separator();
                    read("Controls.txt");
                    System.out.println("\nPress ENTER to continue");
                    String dummy1 = reader.nextLine();
                    continue;
                case "2":
                    separator();
                    read("Rules.txt");
                    System.out.println("\nPress ENTER to continue");
                    String dummy2 = reader.nextLine();
                    continue;
                case "3":
                    separator();
                    read("About.txt");
                    System.out.println("\nPress ENTER to continue");
                    String dummy3 = reader.nextLine();
                    continue;
                case "4":
                    return;

                default:
                    System.out.println("Invalid input.");
            }

        }

    }

    public static void read(String file) {

        // The read method
        try (Scanner fileReader = new Scanner(Paths.get(file))) {
            while(fileReader.hasNextLine()) {
                String stream = fileReader.nextLine();
                System.out.println(stream);
            }
        } catch (Exception error) {
            System.out.println("Oh no! An error occurred!\nError: " + error.getMessage());
        }
    }

    public static void play() {

        Scanner reader = new Scanner(System.in);
        // The main board for the game
        Board main = new Board();

        int count = 0;

        separator();
        System.out.println("New game created! Which sign will turn first? ");
        System.out.println("Enter the corresponding sign.");
        System.out.print("X or O > ");

        while (true) {
            String firstMove = reader.nextLine();
            switch (firstMove) {
                case "X":
                    separator();
                    System.out.println("A new game has started. X will turn first. Pick the corresponding cell you want to populate.");

                    for (int i = 0; i <= 8; ) {
                        main.printBoard();

                        if (i <= 8) {
                            System.out.println("It is X's turn.");
                            int xMove = move("X", i);
                            if (main.setX(xMove)) {
                                System.out.println("Valid move.");
                                main.printBoard();
                                separator();
                                i++;
                            } else {
                                while (!main.setX(xMove)) {
                                    System.out.println("Cell is already populated!");
                                    xMove = move("X", i);
                                    if (main.setX(xMove)) {
                                        System.out.println("Valid move.");
                                        main.printBoard();
                                        separator();
                                        i++;
                                        break;
                                    }
                                }
                            }
                        }


                        if (main.checkForX()) {
                            System.out.println("X won the game!");
                            read("Winner.txt");
                            System.out.println("Press ENTER to go back to main menu.");
                            String back = reader.nextLine();
                            return;
                        }
                        if (main.checkForO()) {
                            System.out.println("O won the game!");
                            read("Winner.txt");
                            System.out.println("Press ENTER to go back to main menu.");
                            String back = reader.nextLine();
                            return;
                        }


                        if (i == 9) {
                            System.out.println("¯\\_(ツ)_/¯");
                            System.out.println("Draw! Press ENTER to go back to main menu.");
                            String back = reader.nextLine();
                            separator();
                            return;
                        }

                        if (i <= 7) {
                            System.out.println("It is O's turn.");
                            int oMove = move("O", i);
                            if (main.setO(oMove)) {
                                System.out.println("Valid move.");
                                main.printBoard();
                                separator();
                                i++;
                            } else {
                                while (!main.setO(oMove)) {
                                    System.out.println("Cell is already populated!");
                                    oMove = move("O", i);
                                    if (main.setO(oMove)) {
                                        System.out.println("Valid move.");
                                        main.printBoard();
                                        separator();
                                        i++;
                                        break;
                                    }
                                }
                            }
                        }

                        if (main.checkForX()) {
                            System.out.println("X won the game!");
                            read("Winner.txt");
                            System.out.println("Press ENTER to go back to main menu.");
                            String back = reader.nextLine();
                            return;
                        }

                        if (main.checkForO()) {
                            System.out.println("O won the game!");
                            read("Winner.txt");
                            System.out.println("Press ENTER to go back to main menu.");
                            String back = reader.nextLine();
                            return;
                        }

                        if (i == 9) {
                            System.out.println("¯\\_(ツ)_/¯");
                            System.out.println("\nDraw! Press ENTER to go back to main menu.");
                            String back = reader.nextLine();
                            separator();
                            return;
                        }

                    }
                case "O":
                    separator();
                    System.out.println("A new game has started. O will turn first. Pick the corresponding cell you want to populate.");

                    for (int i = 0; i <= 8; ) {
                        main.printBoard();

                        if (i <= 8) {
                            System.out.println("It is O's turn.");
                            int oMove = move("O", i);
                            if (main.setO(oMove)) {
                                System.out.println("Valid move.");
                                main.printBoard();
                                separator();
                                i++;
                            } else {
                                while (!main.setO(oMove)) {
                                    System.out.println("Cell is already populated!");
                                    oMove = move("X", i);
                                    if (main.setO(oMove)) {
                                        System.out.println("Valid move.");
                                        main.printBoard();
                                        separator();
                                        i++;
                                        break;
                                    }
                                }
                            }
                        }

                        if (main.checkForX()) {
                            System.out.println("X won the game!");
                            read("Winner.txt");
                            System.out.println("Press ENTER to go back to main menu.");
                            String back = reader.nextLine();
                            return;
                        }

                        if (main.checkForO()) {
                            System.out.println("O won the game!");
                            read("Winner.txt");
                            System.out.println("Press ENTER to go back to main menu.");
                            String back = reader.nextLine();
                            return;
                        }

                        if (i == 9) {
                            System.out.println("¯\\_(ツ)_/¯");
                            System.out.println("\nDraw! Press ENTER to go back to main menu.");
                            String back = reader.nextLine();
                            separator();
                            return;
                        }

                        if (i <= 7) {
                            System.out.println("It is X's turn.");
                            int xMove = move("X", i);
                            if (main.setX(xMove)) {
                                System.out.println("Valid move.");
                                main.printBoard();
                                separator();
                                i++;
                            } else {
                                while (!main.setX(xMove)) {
                                    System.out.println("Cell is already populated!");
                                    xMove = move("X", i);
                                    if (main.setX(xMove)) {
                                        System.out.println("Valid move.");
                                        main.printBoard();
                                        separator();
                                        i++;
                                        break;
                                    }
                                }
                            }
                        }

                        if (main.checkForX()) {
                            System.out.println("X won the game!");
                            read("Winner.txt");
                            System.out.println("Press ENTER to go back to main menu.");
                            String back = reader.nextLine();
                            return;
                        }

                        if (main.checkForO()) {
                            System.out.println("O won the game!");
                            read("Winner.txt");
                            System.out.println("Press ENTER to go back to main menu.");
                            String back = reader.nextLine();
                            return;
                        }

                        if (i == 9) {
                            System.out.println("¯\\_(ツ)_/¯");
                            System.out.println("\nDraw! Press ENTER to go back to main menu.");
                            String back = reader.nextLine();
                            separator();
                            return;
                        }

                    }
                default:
                    System.out.println("Invalid input! Please enter [X] or [O].");
            }
        }

    }

    public static void separator() {
        System.out.println("---------------------------------------------------");
    }

    public static int move(String sign, int move) {
        Scanner reader = new Scanner (System.in);

        while (true) {
            System.out.print("[Move " + (move + 1) + "] Turn: " + sign + " > ");
            String input = reader.nextLine();
            switch (input) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    int returnValue = Integer.valueOf(input);
                    return returnValue;
                default :
                    System.out.println("Invalid input! Please enter the number of the cell you want to populate.");
            }
        }

    }

}
