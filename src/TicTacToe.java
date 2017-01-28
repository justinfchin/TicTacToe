/**
 * Controller Class for TicTacToe
 * @author Justin Chin
 * @version 1.0
 * @since Jan. 3, 2017
 * implement scores???
 */

import java.util.Scanner;

public class TicTacToe {
    //private Player player1;
    //private Player player2;
    private Board.Piece currentPlayer;
    private Board gameBoard;
    private static Scanner input = new Scanner(System.in);
    private GameState currentState;

    public enum GameState{
        PLAYING, XWON, OWON, DRAW;
    }

    public TicTacToe(int size){
        gameBoard = new Board(size); //creates a new board

        //run
        initializeGame();
        gameBoard.printBoard();
        //play the game once

    do{
        playersTurn(currentPlayer);
        gameBoard.printBoard();
        switchPlayer();
        updateGame();
    } while (currentState == GameState.PLAYING);
    }

    /**
     * Sets a Brand New Game
     */
    public void initializeGame(){
        currentPlayer = Board.Piece.X; //X plays first
        currentState = GameState.PLAYING; //Playing State
        gameBoard.reset();  //clears the board
        for (int row = 0; row < gameBoard.getSize(); row++) {
            for (int col = 0; col < gameBoard.getSize(); col++) {
                gameBoard.setBoardCell(Board.Piece.EMPTY,row,col); // set all to empty.
            }
        }

    }

    /**
     * Actions Players Move
     */
    public void playersTurn(Board.Piece player){
        System.out.println("Player " + player);
        int row = input.nextInt() - 1;
        int col = input.nextInt() - 1;
        if (player == Board.Piece.X) gameBoard.setBoardCell(Board.Piece.X,row,col);
        else gameBoard.setBoardCell(Board.Piece.O,row,col);
    }


    /**
     * BE SURE to check a win even though we are
     */
    public void updateGame(){
        if(gameBoard.isDraw()){
            if (gameBoard.isWin(Board.Piece.O)) {
                currentState = GameState.OWON;
                System.out.println(Board.Piece.O + " Wins");
            }
            else if (gameBoard.isWin(Board.Piece.X)) {
                currentState = GameState.XWON;
                System.out.println(Board.Piece.X + " Wins");
            }
            else{
                currentState = GameState.DRAW;
                System.out.println("DRAW");
            }
        }

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
