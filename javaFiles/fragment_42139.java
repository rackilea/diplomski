public interface TriangleListener {
    public void reportTriangle(final QuadEdge triangle);
}

public QuadEdge[] partition(List<PlanarPoint> list, TriangleListener listener) {
    QuadEdge[] convexHullEdges = new QuadEdge[2];
    if (list.size() == 2) {
        //Add edge
    } else if (list.size() == 3) {
        //Add a counter-clockwise oriented triangle
        listener.reportTriangle(new QuadEdge(list));
    }
    ...
}

private class GuibasStolfiWorker extends
        SwingWorker<Void, QuadEdge> implements TriangleListener 
{
    ...
    protected void process(List<QuadEdge> chunks) {
        drawingPanel.addTrianglesToList(chunks);

        drawingPanel.repaint();
    }

    public void done() {
        // Nothing to do - panel has all triangles already
    }

    @Override
    public void reportTriangle(final QuadEdge triangle) {
        publish(triangle);
    }
}

public interface TriangleLsitener {
    public void reportTriangle(final QuadEdge triangle);
}