public class TryMusic {

    //Create array and make posistion 0 = song1
    //if simply array is enough
    Music[] songDetails = { new Music("song name", 5.32, 10),
         new Music("billy", 1.2, 8),
        new Music("hello", 1.5, 9)
    };

    public void go() {
        //print first place in array
        System.out.println(songDetails[0]);
    }

    public static void main(String[] args) {
        new TryMusic().go();
    }
}