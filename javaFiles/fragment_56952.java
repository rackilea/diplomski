shortestPath(Graph<VLabel, ELabel> G,
             Graph<VLabel, ELabel>.Vertex V0,
             Graph<VLabel, ELabel>.Vertex V1,
             final Distancer<? super VLabel> h, //heuristic value
             final Weighter<? super VLabel> vweighter,
             Weighting<? super ELabel> eweighter) {