public static void check(Node node){
  if (node == null || node.getNodeName() == null)
    return;

  // Do PostOrder on all children
  check(node.getFirstChild());  

  // Now that all children were traversed, process the current node:
  System.out.println(node); 

  // Do PostOrder on following siblings
  check(node.getNextSibling();  
}