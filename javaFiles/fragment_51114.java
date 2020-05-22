class NodeThread extends Thread {

    private int nodeId;
    private VirtualNetwork network;

    public NodeThread(int nodeId,VirtualNetwork network) {
        this.network = network;
        this.nodeId = nodeId;
    }
    public void run() {
        /* when you have to send */
        int nodeReceptor = this.nodeId -1; /* neighbor in the array of threads */
        Message m = new Message(this.nodeId,nodeReceptor);
        m.setContent(10);
        network.send(m);

        /* when you have to receive */
        Message m = network.receive(this.nodeId);
        /* it's your decision to implement this in a blocking way or not */
    }
}