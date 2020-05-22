public class TryMusic {      

    Music song1 = new Music("song name", 5.32, 10);
    Music song2 = new Music("billy", 1.2, 8);
    Music song3 = new Music("hello", 1.5, 9);
    //Create array and make posistion 0 = song1
    Music[] songDetails;// = new Music[3];

    {
       //some initializations goes here
       //...
       //create array when you know how many songs you have
       songDetails = new Music[3];
       // and now fill the array. Possibly iteration? if no then simply use {} syntax
        songDetails[0] = song1;
        songDetails[1] = song2;
        songDetails[2] = song3;
    }

    public void go() {
        //print first place in array
        System.out.println(songDetails[0]);
    }

    public static void main(String[] args) {
        new TryMusic().go();
    }
}