void inOrder(AVLNode node, int depth, StringBuilder sb)
{
  if(node == null) return;

  inOrder(node.left, depth+1, sb);

  for(int a=0;a<depth;a++) sb.append(".");
  sb.append(node.data + "\n");

  inOrder(node.right, depth+1, sb);

}