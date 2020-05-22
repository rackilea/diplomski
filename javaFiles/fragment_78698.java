public static void main(String [] args){
    int[][] adj = {
            {0, 0, 0, 1, 0, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 0, 1, 0, 0, 0}, 
            {1, 0, 0, 0, 1, 0, 1, 0, 0}, 
            {0, 0, 0, 1, 0, 1, 0, 0, 0}, 
            {0, 0, 1, 0, 1, 0, 0, 0, 1}, 
            {0, 0, 0, 1, 0, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, 
            { 0, 0, 0, 0, 0, 1, 0, 0, 0} 
    };
    boolean[] visited = new boolean[adj.length];
    int n = adj.length;    
    int m = 1-1; //starting position
    int o = 3-1; //ending position
    System.out.println(DFS(adj, visited, n, m, o));
}

public static List<Integer> DFS(int[][] adj, boolean[] visited, int n, int i, int o){
    visited[i]= true;
    if (i == o) return new LinkedList<Integer>(Arrays.asList(i+1));
    for (int j = 0; j<n;j++){
        if(!(visited[j]) && adj[i][j]==1){
            List<Integer> res = DFS(adj, visited, n, j, o);
            if (res != null) { 
                res.add(0, i+1);
                return res;
            }
        }
    }
    return null; //no path
}