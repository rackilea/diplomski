public class Graph {
int V;
ArrayList<Integer> adjList[];
boolean[] notRoot;
public Graph(int vertex) {
    this.V = vertex;
    adjList = new ArrayList[vertex];
    notRoot = new boolean[vertex];
    for (int i = 0; i < vertex; i++) {
        adjList[i] = new ArrayList<Integer>();
    }
}
public void addEdge(int a, int b) {
    //asuming b is dependent on a
    adjList[b].add(a);
    notRoot[a]=true;
}
int maxDepthDfs(int root){
    int depth=1;
    for(int i=0;i<adjList[root].size();i++){
        int child=adjList[root].get(i);
        depth=Math.max(maxDepthDfs(child)+1,depth);
    }
    return depth;
}
public int getSolution(){
    int ans=0;
    for(int i=0;i<V;i++){
        if(!notRoot[i])
            ans=Math.max(ans,maxDepthDfs(i));
    }
    return ans;
}
}