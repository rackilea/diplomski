public interface Player {
    void playOne();
    void playTwo();
}

public class CurrentPlayer implements Player {
    @Override
    public void playOne() { 
        // code
    }

    @Override
    public void playTwo() {
        // code
    }
}

private class CustomPlayer implements Player {
    @Override
    public void playOne() {
        // code
    }

    @Override
    public void playTwo() {
        // code
    }
}

public class Notifier {
    Player mPlayer;
 }