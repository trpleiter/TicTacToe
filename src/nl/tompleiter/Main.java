package nl.tompleiter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welkom bij het spel boter, kaas en eieren!");

//        Grid aanmaken
        Field[] board = new Field[9];

        for (int i = 0; i < 9; i++) {
            board[i] = new Field(Integer.toString(i));
        }
        printBoard(board);

//        Speelmogelijkheden

        Player playerA = new Player("Kruisje", "X");
        Player playerB = new Player("Rondje", "O");

        Game game = new Game(playerA, playerB);

        boolean didWin = false;
        while (didWin == false) {
            System.out.println("\n Geef een cijfer op om " + game.getCurrentPlayer().getName() + " te zetten");

            Scanner userInput = new Scanner(System.in);
            int selectField = userInput.nextInt();

            String currentPlayerToken = game.getCurrentPlayer().getToken();
            board[selectField].setToken(currentPlayerToken);

            printBoard(board);

            didWin = game.didPlayerWin(board);


            if (didWin) {
                game.getCurrentPlayer().setScore(1);
                System.out.println("\n Gefeliciteerd, je hebt gewonnen: " + game.getCurrentPlayer().getName());
                System.out.println("Speler " + playerA.getName() + " heeft een score van " + playerA.getScore());
                System.out.println("Speler " + playerB.getName() + " heeft een score van " + playerB.getScore());
            }

            game.switchPlayer();
        }

    }

    public static void printBoard(Field[] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i].getToken());

            boolean isEndOfRow = (i + 1) % 3 == 0;
            boolean isLastField = i == 8;

            if (isEndOfRow == false) {
                System.out.print(" | ");
            }
            if (isEndOfRow && !isLastField) {
                System.out.println("\n__________");
            }
        }
    }

}