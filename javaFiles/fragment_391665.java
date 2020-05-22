public class Nodes {

    ArrayList<Circle> circles;
    ArrayList<Squares> squares;
    private List<NodesListener> listeners;

    public Nodes() {
        circles = new ArrayList<Circles>();
        squares = new ArrayList<Squares>();
        listeners = new ArrayList<>(25);
    }

    public void addNodesListener(NodesListener listener) {
        listeners.add(listener);
    }

    public void addCircle(Circle c) {
        circles.add(c);
        for (NodesListener listener : listeners) {
            listener.nodesCircleWasAdded(this, c);
        }
    }

}