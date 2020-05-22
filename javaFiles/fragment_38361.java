public static void main(String[] args) {
    In in = new In("Data.txt");
    int T = in.readInt(); // 3
    int something = in.readInt(); // 4
    for (int t = 1; t <= T; t++) {
        System.out.println("Case " + t + ":");
        Edge w = new Edge(in);
    }
}