public class Super {

    private final Runnable subClassCode;

    public Super(Runnable finalizeCode) {
        subClassCode = finalizeCode;
    }

    public final void doThings() {
        // do stuff
        subClassCode.run();
    }

}

public class Sub extends Super {

    public Sub() {
        super(() -> {
            // code to be executed in doThings()
        });
    }

}