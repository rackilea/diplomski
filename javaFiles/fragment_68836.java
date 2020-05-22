import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;


public class DirectedDFS {

    private final Digraph g;
    private final int source;

    private boolean[] marked;
    private int[] edgeFrom;

    public DirectedDFS(Digraph g, int source) {
        this.g = g;
        this.source = source;
        init(g);
        dfs(g, source);
    }

    private void init(Digraph g) {
        this.marked = new boolean[g.V()];
        this.edgeFrom = new int[g.V()];
        Arrays.fill(edgeFrom, -1);
    }

    private void dfs(Digraph g, int source) {

        marked[source] = true;
        for (int vertex : g.adj(source)) {
            if (!marked[vertex]) {
                edgeFrom[vertex] = source;
                dfs(g, vertex);
            }
        }
    }

    public boolean hasPath(int v) {
        return marked[v];
    }

    public Iterable<Integer> path(int v) {
        if (hasPath(v)) {
            final Deque<Integer> paths = new ArrayDeque<>();
            int vertex = v;
            paths.push(v);
            while ((vertex = edgeFrom[vertex]) != -1) {
                paths.push(vertex);
            }
            return paths;
        }
        return (Iterable<Integer>) Collections.emptyIterator();
    }

}