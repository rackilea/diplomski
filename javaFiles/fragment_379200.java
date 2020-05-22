public class Main {

    static int observable = 0;

    static void setObservable(int newValue) {
        if (observable != newValue) {
            System.out.printf("Observable int has been changed from %d to %d.%n", observable, newValue);
            observable = newValue;
        }
    }

    public static void main(String[] args) {

        observable = 1; // Nothing notified us that value has been changed

        setObservable(2); // Console output 'Observable int changed from 1 to 2.'
    }
}