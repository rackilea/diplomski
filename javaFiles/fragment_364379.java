public class TryMusic {

    //Create array and make posistion 0 = song1
    Music[] songDetails;// = new Music[3];

    {
        //if you still need initialization block, but don't need field for each song
        songDetails = new Music[3];
        //possibly iteration? if no then simply use {} syntax instead
        songDetails[0] = new Music("song name", 5.32, 10);
        songDetails[1] = new Music("billy", 1.2, 8);
        songDetails[2] = new Music("hello", 1.5, 9);
    }

    public void go() {
        //print first place in array
        System.out.println(songDetails[0]);
    }

    public static void main(String[] args) {
        new TryMusic().go();
    }
}