/**
 * Board Class for TicTacToe
 * @author Justin Chin
 * @author Cyndi Chin
 * @version 1.0
 * @since Jan. 3, 2017
 */
public class Board {
    private int size;               //# of rows and columns
    private Player boardArray[][];   //array of Players

    public Board(int size){
        this.size = size;                   //initialize size
        boardArray = new Player[size][size]; //initialize data structure
    }

    /**
     * Checks if Board is Full
     * @return True if Board is Full, else False.
     */
    public boolean isBoardFull(){
        //Loop through all the elements
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(boardArray[i][j] == null) return false;
            }
        }
        return true;
    }

    /**
     * Checks if There is a winner
     * @return True if There is a Winner, else False.
     */
    public boolean isWin(){
        //3 in the Row
        if
        //3 in the Column
        //3 in the Diagonal
        //3 in the Reverse Diagonal
        return true;
    }

    /**
     * Retrieve Look of the Winner.
     * @return The Look of the Winner.
     */
    public Player whoWon(){
        return Player;
    }

    /**
     * Resets the Board
     */
    public void reset(){
        boardArray = new Player[size][size]; //creates a new array
    }


}
