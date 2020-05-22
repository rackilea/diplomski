public class MyReader implements Callable<Void> {

    private final String name;
    private final SharedData sharedData;

    public MyReader(final String name, final SharedData sharedData) {
        this.name = name;
        this.sharedData = sharedData;
    }

    @Override
    public Void call() {
        //do stuff
        return null;
    }
}

public class MyWriter implements Callable<Void> {

    private final String name;
    private final SharedData sharedData;

    public MyWriter(final String name, final SharedData sharedData) {
        this.name = name;
        this.sharedData = sharedData;
    }

    @Override
    public Void call() {
        //do stuff
        return null;
    }
}