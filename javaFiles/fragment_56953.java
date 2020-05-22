public class WeightComparator implements
        Comparator<Graph<VLabel, ELabel>.Vertex> {

    private Graph<VLabel, ELabel> G;
    private Graph<VLabel, ELabel>.Vertex V0;
    private Graph<VLabel, ELabel>.Vertex V1;
    private Distancer<? super VLabel> h; //heuristic value
    private Weighter<? super VLabel> vweighter;
    private Weighting<? super ELabel> eweighter;

    public WeightComparator() {

    }

    @Override
    public int compare(Graph<VLabel, ELabel>.Vertex o1, Graph<VLabel, ELabel>.Vertex o2) {
        // Your compare statement
    }

    // Getters and setters for all variables
}