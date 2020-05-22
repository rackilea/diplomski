long BFSTotal = 0;
long BFS2Total = 0;
long DFSTotal = 0;

for (int i = 0; i < 10000; i++) {
    TreeNode root = randomTree(10000);

    long start = System.currentTimeMillis();
    minDepthDFS(root);
    DFSTotal += System.currentTimeMillis() - start;

    start = System.currentTimeMillis();
    minDepthBFS(root);
    BFSTotal += System.currentTimeMillis() - start;

    start = System.currentTimeMillis();
    minDepthBFS2(root);
    BFS2Total += System.currentTimeMillis() - start;
}

System.out.println("BFS: " + BFSTotal);
System.out.println("BFS2: " + BFS2Total);
System.out.println("DFS: " + DFSTotal);