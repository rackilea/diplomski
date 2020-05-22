currLevel = 0;
currNode = root;
do {
   node = read();
   if (somethingRead()) {
      // If this one is one level below the last one, it goes in as a child and we're done
      if (node.level == currNode.level + 1) {
         currNode.addChild(node);
         currNode = node;
      } else {
         // Otherwise this one has to be at a level above this node's child, so back up
         while (node.level >= currNode.level) {
            currNode = currNode.parent(); // check for root left out here ...
         }
         if (node.level == currNode.level + 1) {
            currNode.addChild(node);
            currNode = node;
         } else {
            // handle illegal condition in list
         }
      }
   }
} while (moreNodesToRead());