public class Main implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        // ...
    }

    public static void main(String[] args) {
        // ...
        observable.addObserver(new Main());
    }
}