package Model;

import Enums.GameName;
import Enums.GameType;

public class GameModel {
    public GameName gameName;
    public GameType gameType;
    public Player player1;
    public Player player2;

    private static GameModel single_instance = null;
    //this makes it singleton.
    public static GameModel getInstance(){
        if(single_instance == null)
            single_instance = new GameModel();

        return single_instance;
    }




}
