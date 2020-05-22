public class TryMusic {

    //Create array and make posistion 0 = song1
    List<Music> songDetails = new ArrayList(){{
       add(new Music("song name", 5.32, 10));
       add(new Music("song name", 5.32, 10));
       add(new Music("hello", 1.5, 9));
    }};


    public void go() {
        //print first place in array
        System.out.println(songDetails.get(0));
    }

    public static void main(String[] args) {
        new TryMusic().go();
    }
}