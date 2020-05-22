void preorder(Node root)
{
   // Your code goes here
   if(root == null) return;
   Stack<Node> stack = new Stack<Node>();

   stack.push(root);
   while(!stack.isEmpty()) {
       Node cur = stack.pop();
       System.out.print(cur.data + " ");

       if(cur.right != null) {
           stack.push(cur.right);
       }

       if(cur.left != null) {
           stack.push(cur.left);
       }

   }
}