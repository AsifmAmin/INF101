package Test;

import Controller.GameController;
import Controller.TicTacToeController;
import Enums.GameName;
import Enums.GameType;
import Model.GameModel;
import Model.Map;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeControllerTest {

    @Test
    void setGameName() {
        GameController g = new TicTacToeController();
        g.setGameName();
        Assert.assertTrue(GameModel.getInstance().gameName == GameName.TicTacToe);
    }

    @Test
    void initializePlayers() {
        GameController g = new TicTacToeController();
        g.initializePlayers();
        Assert.assertTrue(GameModel.getInstance().player1 != null && GameModel.getInstance().player2 != null);
    }

    @Test
    void setGameType() {
        GameController g = new TicTacToeController();
        g.setGameType(GameType.PlayerVsComputer);
        Assert.assertTrue(GameModel.getInstance().gameType == GameType.PlayerVsComputer);
    }

    @Test
    void setMap() {
        GameController g = new TicTacToeController();
        g.setMap();
        Assert.assertTrue(Map.getInstance().map != null);
    }

    @Test
    void getMapAsString() {
        GameController g = new TicTacToeController();
        g.setMap();
        Assert.assertTrue(!g.getMapAsString().equals(""));
    }

    @Test
    void checkForVictory() {
        GameController g = new TicTacToeController();
        g.setMap();
        Assert.assertTrue(g.checkForVictory() == false);
    }

    @Test
    void getVictoryPlayerName() {
        GameController g = new TicTacToeController();
        Assert.assertTrue(g.getVictoryPlayerName().equals(""));
    }

    @Test
    void checkIfMapFull() {
        GameController g = new TicTacToeController();
        Assert.assertTrue(g.checkIfMapFull() == false);
    }

    @Test
    void setMovementOnMap() {
        GameController g = new TicTacToeController();
        g.initializePlayers();
        g.setMap();
        g.setPlayerOneTurn();
        g.setGameName();
        g.setMovementOnMap(1, 1);
        Assert.assertTrue(Map.getInstance().map[0][0].contains("x"));
    }
    @Test
    void setPlayerOneTurn() {
        GameController g = new TicTacToeController();
        g.initializePlayers();
        g.setPlayerOneTurn();
        Assert.assertTrue(GameModel.getInstance().player1.playerTurn == true);
    }

    @Test
    void setPlayerTwoTurn() {
        GameController g = new TicTacToeController();
        g.initializePlayers();
        g.setPlayerTwoTurn();
        Assert.assertTrue(GameModel.getInstance().player2.playerTurn == true);
    }

    @Test
    void addPlayerOneMovement() {
        GameController g = new TicTacToeController();
        g.initializePlayers();
        g.addPlayerOneMovement(1, 1);
        Assert.assertTrue(GameModel.getInstance().player1.movesX.get(0) == 1 && GameModel.getInstance().player1.movesY.get(0) == 1);
    }

    @Test
    void addPlayerTwoMovement() {
        GameController g = new TicTacToeController();
        g.initializePlayers();
        g.addPlayerTwoMovement(1, 1);
        Assert.assertTrue(GameModel.getInstance().player2.movesX.get(0) == 1 && GameModel.getInstance().player2.movesY.get(0) == 1);
    }

    @Test
    void checkIfMoveValid() {
        GameController g = new TicTacToeController();
        Assert.assertTrue(g.checkIfMoveValid(0, 0) == false);
        Assert.assertTrue(g.checkIfMoveValid(1, 1) == true);
    }
}