public class Dialog extends Container implements Runnable {
    protected RavelSequence sequence;

    public Dialog(RavelSequence sequence) {
        this.sequence = sequence; // or any other mean to set your RavelSequence: setter, dependency injection...
    }

    public void run (){
        if (somethingHappens)
            sequence.hit();
    }
}