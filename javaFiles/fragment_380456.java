private static void printPath(List<Edge> path)
{
    System.out.println("Path: ");
    for (int i=0; i<path.size(); i++)
    {
        Edge e = path.get(i);
        System.out.println(
            "Edge "+e+
            " flow "+e.getFlow()+
            " cap "+e.getCapacity());
    }
}