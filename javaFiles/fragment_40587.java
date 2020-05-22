public class Dfs {
    public static void main(String[] args) {
        int[][] arr = {
                // 1 2 3 4 5 6 7 8 9 10
                { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 }, // 1
                { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, // 2
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 3
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 4
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, // 5
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 6
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0 }, // 7
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 8
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, // 9
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } // 10
        };
        boolean [] visited = new boolean[10];

        dfs(0, arr, visited);

    }

    public static void dfs(int i, int[][] mat, boolean[] visited) {
        if(!visited[i]) {
            visited[i] = true; // Mark node as "visited"
            System.out.print( (i+1) + " ");

            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && !visited[j]) {
                    dfs(j, mat, visited); // Visit node
                }
            }
        }
    }
}