/**
 * Controller Class for TicTacToe
 * @author Justin Chin
 * @author Cyndi Chin
 * @version 1.0
 * @since Jan. 3, 2017
 */

import java.util.Scanner;

public class TicTacToe {
    //private Player player1;
    //private Player player2;
    private Board.Piece currentPlayer;
    private Board gameBoard;
    private static Scanner input = new Scanner(System.in);

    public TicTacToe(int size){
        gameBoard = new Board(size); //creates a new board

        //run
        initializeGame();
        gameBoard.printBoard();
        //play the game once


    }

    /**
     *
     */
    public void initializeGame(){
        currentPlayer = Board.Piece.X; //X plays first
        gameBoard.reset();  //clears the board
        for (int row = 0; row < gameBoard.getSize(); row++) {
            for (int col = 0; col < gameBoard.getSize(); col++) {
                gameBoard.setBoardCell(Board.Piece.EMPTY,row,col); // set all to empty.
            }
        }

                            //set score to 0?
    }

    /**
     *
     */
    public void playersTurn(Board.Piece player){
        System.out.println("Player" + player);
        int row = input.nextInt() - 1;
        int col = input.nextInt() - 1;
        gameBoard.setBoardCell(Board.Piece.X,row,col);
    }


    /**
     *
     */
    public void updateGame(){

    }

    /**
     * Switches the Current Player
     */
    private void switchPlayer(){
        currentPlayer = (currentPlayer == Board.Piece.X) ? Board.Piece.O : Board.Piece.X;
    }

    //To Test Game
    public static void main(String[] args) {
            new TicTacToe(3);
    }
}
