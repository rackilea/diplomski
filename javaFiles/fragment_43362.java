abstract class Processor {
    private Processor successor;

    public void setSuccessor(Processor successor) { this.successor = successor; }

    public List process(List input) {
        List processed = this.internalProcess(input);
        if (successor != null) { return successor.process(processed); }
        return processed;
    }

    protected abstract List internalProcess(List input);

}