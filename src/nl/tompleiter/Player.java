package nl.tompleiter;

public class Player {

    private String name;
    private String token;
    private int score;


    //    Constructor
    public Player(String name, String token) {
        this.name = name;
        this.token = token;
        this.score = 0;
    }

    public int getScore () {
        return score;
    }

    public String getName () {
        return name;
    }

    public String getToken () {
        return token;
    }

    public void setScore (int extraPoints) {
        score ++;
    }
}
