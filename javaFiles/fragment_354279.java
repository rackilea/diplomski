import java.util.LinkedHashSet;
import java.util.Set;

public class DelaunayEdges
{
    public static void main(String[] args)
    {
        int triangleIndices[] = new int[] { 1, 0, 2, 1, 2, 3 };
        Set<Edge> edges = computeEdges(triangleIndices);
        System.out.println("Edges: "+edges);
    }

    static class Edge
    {
        private final int vertex0;
        private final int vertex1;
        public Edge(int vertex0, int vertex1)
        {
            this.vertex0 = vertex0;
            this.vertex1 = vertex1;
        }
        @Override
        public String toString()
        {
            return "("+vertex0+","+vertex1+")";
        }
        @Override
        public int hashCode()
        {
            return vertex0 ^ vertex1;
        }
        @Override
        public boolean equals(Object object)
        {
            if (this == object)
            {
                return true;
            }
            if (object == null)
            {
                return false;
            }
            if (getClass() != object.getClass())
            {
                return false;
            }
            Edge that = (Edge) object;
            return 
                (this.vertex0 == that.vertex0 &&
                 this.vertex1 == that.vertex1) ||
                (this.vertex0 == that.vertex1 &&
                 this.vertex1 == that.vertex0);
        }
    }

    private static Set<Edge> computeEdges(int triangleIndices[])
    {
        Set<Edge> edges = new LinkedHashSet<Edge>();
        for (int i=0; i<triangleIndices.length; i+=3)
        {
            int i0 = triangleIndices[i+0];
            int i1 = triangleIndices[i+1];
            int i2 = triangleIndices[i+2];
            edges.add(new Edge(i0, i1));
            edges.add(new Edge(i1, i2));
            edges.add(new Edge(i2, i0));
        }
        return edges;
    }
}