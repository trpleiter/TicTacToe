package nl.tompleiter;

public class Field {
    private String token;
    private boolean isOccupied;

    public Field(String token) {
        this.token = token;
        isOccupied = false;
    }

    public void setToken (String token) {
        if ( isOccupied == false) {
        this.token = token;
    }
        isOccupied = true;
    }

    public String getToken() {
        return token;
    }
}
