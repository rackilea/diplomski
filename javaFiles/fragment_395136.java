static long nodes = 0;

static void constructTree(int N) {
   if (N > 0) {
       ++nodes;
       constructTree(N-1);
   }
   if (N > 1) {
       ++nodes;
       constructTree(N-2);
   }
   if (N > 2) {
       ++nodes;
       constructTree(N-3);
   }
}

public static final void main (String[] args) throws Exception {
    nodes = 1;
    constructTree(28);
    System.out.println(nodes);
}