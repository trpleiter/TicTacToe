package nl.tompleiter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welkom bij het spel boter, kaas en eieren!");

//        Grid aanmaken
        String[] board = new String[9];

        for (int i = 0; i < 9; i++) {
            board[i] = Integer.toString(i);
        }
        printBoard(board);

//        Speelmogelijkheden
        String currentPlayer = "X";
        boolean didWin = false;
        while (didWin == false) {
            System.out.println("\n Geef een cijfer op om " + currentPlayer + " te zetten");
            Scanner userInput = new Scanner(System.in);

            int selectField = userInput.nextInt();

            board[selectField] = currentPlayer;

            printBoard(board);

            didWin = didPlayerWin(board, currentPlayer);

            if (didWin == true) {
                System.out.println("\n Gefeliciteerd, je hebt gewonnen: " + currentPlayer);
            }

            currentPlayer = switchPlayer(currentPlayer);
        }

    }

    public static void printBoard(String[] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i]);

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

    public static String switchPlayer(String currentPlayer) {
        if (currentPlayer == "X") {
            return "O";
        } else {
            return "X";
        }
    }

    public static boolean didPlayerWin(String[] board, String currentPlayer) {
//        Horizontaal
        if (board[0] == currentPlayer && board[1] == currentPlayer && board[2] == currentPlayer) {
            return true;
        }
        if (board[3] == currentPlayer && board[4] == currentPlayer && board[5] == currentPlayer) {
            return true;
        }
        if (board[6] == currentPlayer && board[7] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }
//        Verticaal
        if (board[0] == currentPlayer && board[3] == currentPlayer && board[6] == currentPlayer) {
            return true;
        }
        if (board[1] == currentPlayer && board[4] == currentPlayer && board[7] == currentPlayer) {
            return true;
        }
        if (board[2] == currentPlayer && board[5] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }
//        Diagonaal
        if (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }
        if (board[6] == currentPlayer && board[4] == currentPlayer && board[2] == currentPlayer) {
            return true;
        }

        return false;
    }
}