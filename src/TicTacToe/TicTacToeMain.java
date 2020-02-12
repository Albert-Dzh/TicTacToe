package TicTacToe;


import java.util.Scanner;

public class TicTacToeMain {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean gameEnded = false;
        char[] coordinates;
        TicTacToeGame Game = new TicTacToeGame();
        Game.printField();

        while(!gameEnded) {
            System.out.println("Enter the coordinates: ");
            coordinates = in.nextLine().toCharArray();
            if (Character.isDigit(coordinates[0]) && Character.isDigit(coordinates[2])) {
                if (coordinates[0] + coordinates[2] >= 98 &&  coordinates[0] + coordinates[2] <= 102) {
                    Game.input(coordinates[0], coordinates[2]);
                    gameEnded = Game.analyze();
                    Game.printField();
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
        System.out.println(Game.getStatus());
    }
}