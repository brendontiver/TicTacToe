
/**
 * Basic Tic Tac Toe game
 *
 * Created by Brendon Tiver
 * 10/30/18
 */

public class TicTacToe {

    public static void main(String[] args) {

        Gameboard myGame = new Gameboard();

        int counter = 1;

        myGame.printBoard();

        while(myGame.gameActive()){
            if(counter % 2 == 0){
                myGame.askPlayer('O');
            } else {
                myGame.askPlayer('X');
            }

            myGame.printBoard();
            myGame.checkWinner();
            myGame.checkStalemate();
            counter++;
        }





    }
}
