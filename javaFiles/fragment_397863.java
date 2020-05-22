public class DepthFirstPaths <T extends GraphType> implements PathInterface {
    private final int start;        

    public DepthFirstPaths (T G, int s) {
        //This line won't give you errors anymore
        //except if GraphType doesn't have a numVertex method
        int vCount = G.numVertex();
        start = s;

        DFS(G, s);
    }

    //Other methods
    ....
}