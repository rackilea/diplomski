Graph<Integer, String> basis = new SparseMultigraph<Integer, String>();
final Layout<Integer, String> layout = new CircleLayout<Integer, String>(
    basis);

layout.setSize(new Dimension(300, 300));
VisualizationViewer<Integer, String> vv = new VisualizationViewer<Integer, String>(
    layout);

final PickedState<Integer> pickedState = vv.getPickedVertexState();

// Attach the listener that will print when the vertices selection changes.
pickedState.addItemListener(new ItemListener() {

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object subject = e.getItem();
        // The graph uses Integers for vertices.
        if (subject instanceof Integer) {
            Integer vertex = (Integer) subject;
            if (pickedState.isPicked(vertex)) {
                System.out.println("Vertex " + vertex
                    + " is now selected");
            } else {
                System.out.println("Vertex " + vertex
                    + " no longer selected");
            }
        }
    }
});