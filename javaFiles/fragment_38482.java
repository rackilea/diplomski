public void insert(int data) {
     if (root == null) {
         root = new Node(data);
         return;
     }

     Queue<Node> nodesToProcess = new LinkedList<>();
     nodesToProcess.add(root);

     while (true) {
         Node actualNode = nodesToProcess.poll();

         // Left child has precedence over right one
         if (actualNode.left == null) {
             actualNode.left = new Node(data);
             return;
         }
         if (actualNode.right == null) {
             actualNode.right = new Node(data);
             return;
         }

         // I have both children set, I will process them later if needed
         nodesToProcess.add(actualNode.left);
         nodesToProcess.add(actualNode.right);
     }
}