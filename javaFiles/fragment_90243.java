import java.util.List;

Node<String> parentNode = new Node<String>("Parent"); 
Node<String> childNode1 = new Node<String>("Child 1", parentNode);
Node<String> childNode2 = new Node<String>("Child 2");     

childNode2.setParent(parentNode); 

Node<String> grandchildNode = new Node<String>("Grandchild of parentNode. Child of childNode1", childNode1); 
List<Node<String>> childrenNodes = parentNode.getChildren();