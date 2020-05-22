public class Main {

    public static void getPaths(int[][]A, int i, int j, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> allPaths) {
        int n = A.length;
        if (i>=n || j>=n) return;

        path.add(A[i][j]);

        if (i==n-1 && j==n-1) {
            allPaths.add(path);
            return;
        }
        getPaths(A, i, j+1, new ArrayList<>(path), allPaths);
        getPaths(A, i+1, j, path, allPaths);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        getPaths(new int[][] { {1,2,3},{4,5,6},{7,8,9}}, 0,0, new ArrayList<Integer>(), allPaths );
        System.out.println(allPaths);
    }
}