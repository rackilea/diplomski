Node node=tree.root; Node n;
for( i=1 ;i <tokens.length; i++){
  n=getNode(node,tokens[i]);
  if(n==null){
    n=addNode(node,tokens[i]);
  }
  node=n;
}