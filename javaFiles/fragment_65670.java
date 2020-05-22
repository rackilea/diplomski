public abstract class A {

    protected abstract int getCounter();

    public void doStuff() {
        int counter = getCounter();
        for (int i=0; i < counter; i++) {
            // do stuff
        }
    }

}