public class TryMusic {

    //Create array and make posistion 0 = song1
    static List<Music> songDetails = new ArrayList(){{
       add(new Music("song name", 5.32, 10));
       add(new Music("song name", 5.32, 10));
       add(new Music("hello", 1.5, 9));
    }};

    public static void main(String[] args) {
        System.out.println(songDetails.get(0));
    }
}