class TheClassThatLoadsTheGraph
{
    private final Map<String, Vertex> idToVertex =
        new LinkedHashMap<String, Vertex>();

    void readVertices()
    {
        ...
        rs = st.executeQuery(query);
        while (rs.next())
        {
            String id = "w"+rs.getInt("id_v");
            Vertex v = new Vertex(
                id, rs.getDouble("x"), rs.getDouble("y"), start.getA(), 0);
            g.addVertex(v);

            // Store the vertex in the map:
            idToVertex.put(id, v);
        }
    }

    void readEdges()
    {
        ...
        rs = st.executeQuery(query);
        while (rs.next())
        {
            String id1 = "w"+rs.getInt(1);
            String id1 = "w"+rs.getInt(2); 
            double weight = rs.getDouble(3);

            // Use the ids to look up the matching vertices
            Vertex v1 = idToVertex.get(id1);
            Vertex v2 = idToVertex.get(id2);
            DefaultWeightedEdge e = g.addEdge(v1, v2);

            g.setEdgeWeight(e, weight);
        }
    } 
}