public class FFTest
{
    /**
     *     B---D
     *    / \ / \
     *   A   .   F
     *    \ / \ /
     *     C---E
     */
    public static void main(String[] args) throws Exception
    {
        FF ff = new FF();

        Vertex vA = new Vertex("A");
        Vertex vB = new Vertex("B");
        Vertex vC = new Vertex("C");
        Vertex vD = new Vertex("D");
        Vertex vE = new Vertex("E");
        Vertex vF = new Vertex("F");
        ff.insertNode(vA);
        ff.insertNode(vB);
        ff.insertNode(vC);
        ff.insertNode(vD);
        ff.insertNode(vE);
        ff.insertNode(vF);

        ff.insertEdge(vA, vB, 3.0f);
        ff.insertEdge(vA, vC, 2.0f);
        ff.insertEdge(vB, vD, 1.0f);
        ff.insertEdge(vB, vE, 4.0f);
        ff.insertEdge(vC, vD, 2.0f);
        ff.insertEdge(vC, vE, 1.0f);
        ff.insertEdge(vD, vF, 2.0f);
        ff.insertEdge(vE, vF, 1.0f);

        float result = ff.fordFulkerson(vA, vF);
        System.out.println(result);
    }
}