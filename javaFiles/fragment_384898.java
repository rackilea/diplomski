Queue<Integer> q = new LinkedList<>();

public Queue<Integer> store_inorder(node n){
      if(n.left!=null)
          store_inorder(n.left);
      q.add(n.data);
      if(n.right!=null)
          store_inorder(n.right);
      return q;
}