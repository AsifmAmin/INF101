package Controller;

import Enums.GameName;
import Enums.GameType;
import Model.GameModel;
import Model.Map;
import Model.Player;

import java.util.Random;

public class FourInRowController extends GameController {

    /**
     * Constructor
     */
    public FourInRowController(){
    }

    /**
     * A method sets game name into singleton model class of the game
     */
    @Override
    public void setGameName() {
        GameModel.getInstance().gameName = GameName.FourInRow;
    }

    /**
     * A method sets game type into Singleton model class of the game
     * @param type
     */
    @Override
    public void setGameType(GameType type) {
        GameModel.getInstance().gameType = type;
    }

    /**
     * A method does map initialization in Singleton map model class and defining its values
     */
    @Override
    public void setMap() {
        Map.getInstance().map = new String[7][6];
        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                if(j == 5)
                    Map.getInstance().map[i][j] = "|   |\n";
                else
                    Map.getInstance().map[i][j] = "|   ";
            }
        }
    }

    /**
     * A method returns a map as a string
     * @return String
     */
    @Override
    public String getMapAsString() {
        String map = "";
        //looping through map and if index j is on the end, add it newline character
        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                if(j == 5)
                    map = map + Map.getInstance().map[i][j] + "\n";
                else
                    map = map + Map.getInstance().map[i][j];
            }
        }
        return map;
    }

    /**
     * A method checks if there is a victorious player
     * @return boolean
     */
    @Override
    public boolean checkForVictory() {
        int xInRow = 0;
        int oInRow = 0;
        boolean playerOneWins = false;
        boolean playerTwoWins = false;
        //loop through the map and check if every cell contains x or o and then add the number. If in the next cell is another character, then put it back to 0
        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                if(j == 0){
                    xInRow = 0;
                    oInRow = 0;
                }
                if(Map.getInstance().map[i][j].contains("x")){
                    xInRow++;
                    oInRow = 0;
                }
                if(Map.getInstance().map[i][j].contains("o")){
                    oInRow++;
                    xInRow = 0;
                }
                if(xInRow == 4)
                    playerOneWins = true;
                if(oInRow == 4)
                    playerTwoWins = true;
            }
        }
        if(playerOneWins){
            GameModel.getInstance().player1.playerVictory = true;
            return true;
        }
        if(playerTwoWins){
            GameModel.getInstance().player2.playerVictory = true;
            return true;
        }
        return false;
    }

    /**
     * A method returns a name of the player who won the game.
     * @return String
     */
    @Override
    public String getVictoryPlayerName() {
        if(GameModel.getInstance().player1.playerVictory)
            return "Player 1";
        if(GameModel.getInstance().player2.playerVictory)
            return "Player 2";
        return "";
    }

    /**
     * A method checks if the map is full with pieces. If it is full returns true. Otherwise returns false.
     * @return boolean
     */
    @Override
    public boolean checkIfMapFull() {
        boolean spaceEmpty = false;
        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                if(!Map.getInstance().map[i][j].contains("x") && !Map.getInstance().map[i][j].contains("o"))
                    spaceEmpty = true;
            }
        }
        if(spaceEmpty)
            return false;
        return true;
    }

    /**
     * A method makes a random move for the dummy computer
     */
    @Override
    public void makeAComputerMove() {
        int moveX = 0;
        int moveY = 0;
        //make new random moves while those that are made are invalid.
        do{
            Random random = new Random();
            moveX = random.nextInt(7 - 1 + 1) + 1;
            moveY = random.nextInt(6 - 1 + 1) + 1;
        }while(checkIfMoveValid(moveX, moveY) == false);
        this.addPlayerTwoMovement(moveX, moveY);
        this.setMovementOnMap(moveX, moveY);
    }

    /**
     * A method returns the last x coordinate that computer chosen.
     * @return int
     */
    @Override
    public int getLastComputerXCoordinate() {
        return GameModel.getInstance().player2.movesX.get(GameModel.getInstance().player2.movesY.size()-1);
    }

    /**
     * A method returns last y coordinate that computer chosen.
     * @return int
     */
    @Override
    public int getLastComputerYCoordinate() {
        return GameModel.getInstance().player2.movesY.get(GameModel.getInstance().player2.movesY.size()-1);
    }

    /**
     * A method sets changes a map value depending on the last player's movement.
     * @param x
     * @param y
     */
    @Override
    public void setMovementOnMap(int x, int y){
        if(GameModel.getInstance().player1.playerTurn == true){
            if(y == 6)
                Map.getInstance().map[x-1][y-1] = "| x |\n";
            else
                Map.getInstance().map[x-1][y-1] = "| x ";
        }
        else{
            if(y == 6)
                Map.getInstance().map[x-1][y-1] = "| o |\n";
            else
                Map.getInstance().map[x-1][y-1] = "| o ";
        }
    }

    /**
     * A method initializes players in the GameModel Singleton class.
     */
    @Override
    public void initializePlayers(){
        GameModel.getInstance().player1 = new Player();
        GameModel.getInstance().player2 = new Player();
    }

    /**
     * A method sets player one turn to true. Player two is set to false.
     */
    @Override
    public void setPlayerOneTurn() {
        GameModel.getInstance().player1.playerTurn = true;
        GameModel.getInstance().player2.playerTurn = false;
    }

    /**
     * A method sets player two turn to true. Player one is set to false.
     */
    @Override
    public void setPlayerTwoTurn() {
        GameModel.getInstance().player1.playerTurn = false;
        GameModel.getInstance().player2.playerTurn = true;
    }

    /**
     * A method adds player's movement into player1 property of GameModel Singleton class.
     * @param x
     * @param y
     */
    @Override
    public void addPlayerOneMovement(int x, int y) {
        GameModel.getInstance().player1.movesX.add(x);
        GameModel.getInstance().player1.movesY.add(y);
    }

    /**
     * A method adds player's movement into player1 property of GameModel Singleton class.
     * @param x
     * @param y
     */
    @Override
    public void addPlayerTwoMovement(int x, int y) {
        GameModel.getInstance().player2.movesX.add(x);
        GameModel.getInstance().player2.movesY.add(y);
    }

    /**
     * A method checks if the movement that player chose is valid.
     * @param x
     * @param y
     * @return boolean
     */
    @Override
    public boolean checkIfMoveValid(int x, int y) {
        //checking if move is valid. If input is less than 1 or more than 7 for row and 6 for column, then the move is invalid.
        if(x < 1 || x > 7 || y < 1 || y > 6)
            return false;
        //go through all the previous moves of both players and if the move already exists then the move is invalid
        boolean moveExists = false;
        for(int i=0; i<GameModel.getInstance().player1.movesX.size(); i++){
            if(GameModel.getInstance().player1.movesX.get(i) == x && GameModel.getInstance().player1.movesY.get(i) == y)
                moveExists = true;
        }
        for(int i=0; i<GameModel.getInstance().player2.movesX.size(); i++){
            if(GameModel.getInstance().player2.movesX.get(i) == x && GameModel.getInstance().player2.movesY.get(i) == y)
                moveExists = true;
        }
        if(moveExists)
            return false;
        return true;
    }
}
