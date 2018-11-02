
/**
 * Class implementing all functions for the tic tac toe board
 *
 * Created by Brendon Tiver
 * 10/30/18
 */


import java.util.Arrays;
import java.util.Scanner;

public class Gameboard {

    private char[][] board;
    private boolean gameOngoing = true;

    /**
     * Constructor for gameboard class
     */
    public Gameboard() {
        board = new char[3][3];

        /* Fills the 2d array with spaces */
        for (int row = 0; row < board.length; row++) {
            Arrays.fill(board[row], ' ');
        }

    }

    /**
     * This method prints the gameboard to the screen
     */
    public void printBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (col == 0 || col == 1) {
                    System.out.print(board[row][col] + "  |  ");
                } else {
                    System.out.print(board[row][col]);
                }
            }

            if (row == 0 || row == 1) {
                System.out.println("\n-------------");
            }
        }

        System.out.println();
    }

    /**
     * makeMove() method validates player move, return true if move is completed
     */
    public boolean makeMove(char player, int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (board[row][col] != ' ') {
                return false;
            } else {
                board[row][col] = player;
                return true;
            }

        } else {
            return false;
        }
    }

    /**
     * Returns true if the game is still active
     */
    public boolean gameActive(){
        return gameOngoing;
    }

    /**
     * Asks the user to pick a row and column for their move, validates the input, calls makeMove() method
     */

    public void askPlayer(char player){

        Scanner reader = new Scanner(System.in);
        int row, col;

        do{

            System.out.print("Player '" + player + "' please enter a row (1-3): ");
            row = reader.nextInt();

            System.out.print("Player '" + player + "' please enter a column (1-3): ");
            col = reader.nextInt();

        } while(invalidInput(row, col));

        makeMove(player, row-1, col-1);
    }


    /**
     * Method returns true if the user input is invalid
     * (I.E. row/column are not within range of the gameboard or position is already filled)
     */

    public boolean invalidInput(int row, int col){
        if(row > 3 || row < 1 || col > 3 || col < 1 || !isEmpty(row, col)){
            return true;
        }
        return false;
    }


    /**
     * Method to check whether a cell is empty
     * returns true if empty
     */
    public boolean isEmpty(int row, int col){
        if(board[row-1][col-1] == ' '){
            return true;
        }
        System.out.println("That position is taken - try again");
        return false;
    }

    /**
     * Method to check whether there is a winner
     */
    public boolean checkWinner(){

        /* Loop over all rows in the game board to check for 3 X's or O's */
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != ' '){
                gameOngoing = false;
                System.out.println("Player " + board[row][0] + " wins!");
                return true;
            }
        }

        /* Loop over all columns in the game board to check for 3 X's or O's */
        for(int col = 0; col < board[0].length; col++){
            if(board[0][col] == board[1][col] && board [1][col] == board[2][col] && board[0][col] != ' '){
                gameOngoing = false;
                System.out.println("Player " + board[0][col] + " wins!");
                return true;
            }
        }

        /* Check diagonals for 3 X's or O's */
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ' ||
           board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ' ){
            gameOngoing = false;
            System.out.println("Player " + board[1][1] + " wins!");
            return true;
        }

        return false;

    }


    /**
     * Method to check whether the game is over because of a stalemate / if board is full
     */

    public boolean checkStalemate(){
        /* loops through board looking for a space character ' '
        if found, there are still spots left to play on the board
        therefore no stalemate */
       for(int row = 0; row < board.length; row++){
           for(int col = 0; col < board[0].length; col++){
               if(board[row][col] == ' '){
                   return false;
               }
           }
       }
        gameOngoing = false;
        System.out.println("Stalemate!");
        return true;
    }



}

