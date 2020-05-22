public static class MyEventHandler extends PBasicInputEventHandler {
    private PNode node;
    public MyEventHandler(PNode node) {
        this.node = node;
    }

    public PNode getNode() {
        return this.node;
    }
}