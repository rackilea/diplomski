interface StateKeeper {

    public abstract void negateWithoutCheck();

    public abstract void negateWithCheck();

}

class StateKeeperForPrimitives implements StateKeeper {

    private boolean b = true;

    public void negateWithCheck() {
        if (b == false) {
            this.b = true;
        }
    }

    public void negateWithoutCheck() {
        this.b = true;
    }
}

class StateKeeperForObjects implements StateKeeper {

    private Boolean b = true;

    public void negateWithCheck() {
        if (b == false) {
            this.b = true;
        }
    }

    public void negateWithoutCheck() {
        this.b = true;
    }
}

public class Main {

    public static void main(String args[]) {

        StateKeeper[] array = new StateKeeper[10_000_000];

        for (int i=0; i<array.length; ++i)
            //array[i] = new StateKeeperForObjects();
            array[i] = new StateKeeperForPrimitives(); 

        long start = System.nanoTime();

        for (StateKeeper e : array)
            e.negateWithCheck();
            //e.negateWithoutCheck();

        long end = System.nanoTime();

        System.err.println("Time in milliseconds: "+((end-start)/1000000));
    }
}