package Controller;

import Enums.GameType;
import Model.GameModel;
import Model.Player;

public abstract class GameController {
    /**
     * A method sets game name into singleton model class of the game
     */
    public abstract void setGameName();
    /**
     * A method sets game type into Singleton model class of the game
     * @param type
     */
    public abstract void setGameType(GameType type);
    /**
     * A method does map initialization in Singleton map model class and defining its values
     */
    public abstract void setMap();
    /**
     * A method initializes players in the GameModel Singleton class.
     */
    public abstract void initializePlayers();
    /**
     * A method sets player one turn to true. Player two is set to false.
     */
    public abstract void setPlayerOneTurn();
    /**
     * A method sets player two turn to true. Player one is set to false.
     */
    public abstract void setPlayerTwoTurn();
    /**
     * A method adds player's movement into player1 property of GameModel Singleton class.
     * @param x
     * @param y
     */
    public abstract void addPlayerOneMovement(int x, int y);
    /**
     * A method adds player's movement into player1 property of GameModel Singleton class.
     * @param x
     * @param y
     */
    public abstract void addPlayerTwoMovement(int x, int y);
    /**
     * A method checks if the movement that player chose is valid.
     * @param x
     * @param y
     * @return boolean
     */
    public abstract boolean checkIfMoveValid(int x, int y);
    /**
     * A method sets changes a map value depending on the last player's movement.
     * @param x
     * @param y
     */
    public abstract void setMovementOnMap(int x, int y);
    /**
     * A method returns a map as a string
     * @return String
     */
    public abstract String getMapAsString();
    /**
     * A method checks if there is a victorious player
     * @return boolean
     */
    public abstract boolean checkForVictory();
    /**
     * A method returns a name of the player who won the game.
     * @return String
     */
    public abstract String getVictoryPlayerName();
    /**
     * A method checks if the map is full with pieces. If it is full returns true. Otherwise returns false.
     * @return boolean
     */
    public abstract boolean checkIfMapFull();
    /**
     * A method makes a random move for the dummy computer
     */
    public abstract void makeAComputerMove();
    /**
     * A method returns the last x coordinate that computer chosen.
     * @return int
     */
    public abstract int getLastComputerXCoordinate();
    /**
     * A method returns last y coordinate that computer chosen.
     * @return int
     */
    public abstract int getLastComputerYCoordinate();
}
