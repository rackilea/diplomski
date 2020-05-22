class EdgeContainer implements Comparable<EdgeContainer> {

    private static final Comparator<edge> comp = ; // that comparator above
    private final edge edge;
    EdgeContainer(Edge edge) { this.edge = edge; }
    public int compareTo(EdgeContainer e) { return comp.compare(edge, e.edge); }
    public edge getEdge() { return edge; }
}

List <EdgeContainer>ar=new ArrayList<>(); 
for(int i=0;i<e;i++)
{
   int u=ss.nextInt();
   int v=ss.nextInt();
   int w=ss.nextInt();
   ar.add(new EdgeContainer(new edge(u,v,w)));
}

PriorityQueue<EdgeContainer> qr = new PriorityQueue(ar);