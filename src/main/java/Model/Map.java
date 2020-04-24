package Model;

public class Map {
    private static Map single_instance = null;

    public static Map getInstance(){
        if(single_instance == null)
            single_instance = new Map();

        return single_instance;
    }

    public String map[][];
}
