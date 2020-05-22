public class TryMusic {

//Create array and make posistion 0 = song1
static Music[] songDetails = new Music[3];
static {
    songDetails[0] = new Music("song name", 5.32, 10);
    songDetails[1] = new Music("billy", 1.2, 8);
    songDetails[2] = new Music("hello", 1.5, 9);
}


public static void main(String[] args) {
    System.out.println(songDetails[0]);
}

}