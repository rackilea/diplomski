public class Player implements Parcelable{
    /* ... */

    public Player(Parcel source){
        /* ... */
    }

    public Player(int score, String name){
        this.score = score;
        this.name = name; 
    }
}