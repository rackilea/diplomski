Node currNode = null;
List<Root> roots = new ArrayList<Root>();

do {
      Node node = generateNode(nodesList.next());
      if (node.getLevel() == 1) { //implies root level node
         roots.add(node);
         currNode = node;
      } else if (currNode == null) {
         // ... handle misformed input ... first node isn't level 1, ignore it
      } else if (node.getLevel() == currNode.getLevel() + 1) {
         currNode.childrenList.addChild(node);
         node.setParent(currNode);
         currNode = node;
      } else {
         Node savedCurrNode = currNode;
         while (node.getLevel() <= currNode.getLevel()) {
             currNode = currNode.getParent();
         }
         if (node.getLevel() == currNode.getLevel() + 1) {
             currNode.childrenList.addChild(node);
             node.setParent(currNode);
             currNode = node;
         } else {
             // ... handle misformed input ... node level > last node level + 1, ignore it
             currNode = savedCurrNode;
         }

} while (hasMoreNodes(nodesList));