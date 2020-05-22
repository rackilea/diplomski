abstract class AbstractTalk implements Talk {
    public void sayIt() {
        trace();
        startMeasure();

        doSayIt();

        stopMeasure();
    }

    abstract protected doSayIt(); // here implement the logic
}