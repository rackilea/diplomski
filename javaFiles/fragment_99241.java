public static void main(String[] args) {

    ArrayList<Integer>[] adj = new ArrayList[10];

    for (int i = 0; i < adj.length; i++)
        adj[i] = new ArrayList<>();

    Scanner in = new Scanner(System.in);

    int nodes = in.nextInt();
    int edges = in.nextInt();

    for (int i = 0; i < edges; ++i) {
        int x = in.nextInt();
        int y = in.nextInt();
        adj[x].add(y);
        adj[y].add(x);
    }

    for (int i = 0; i < adj.length; i++)
        System.out.println(adj[i]);

}