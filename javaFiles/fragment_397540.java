public class Music {

    private static instance Music instance;

    private Music() {
        // initialize your stuff here
    }

    // have your instance methods here

    /**
      * This is the method to access the Music singleton
      */
    public static Music getInstance() {
        if (instance == null) {
            instance = new Music();
        }
        return instance;
    }
}