public static double 
interpolateZ(DelaunayTriangulationBuilder triangulation,
             Coordinate coordinate) {
    QuadEdgeSubdivision quadEdgeSubdivision = triangulation.getSubdivision();
    QuadEdge edge = quadEdgeSubdivision.locate(coordinate);
    return new Vertex(coordinate.x, coordinate.y)
            .interpolateZValue(edge.orig(), edge.dest(), edge.oNext().dest());
}