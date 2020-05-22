int deletedNodes = 0;
  int currentIndex = 0; // check if 1 or 0
  currentNode = fist;
  while(currentNode != null){ // I guess lastNode.getNextNode() is null
    if(//should remove){
      remove(currentIndex);
      deletedNodes++
      // probably no need to change the index as all element should have been shifted back one index
    } else {
      currentIndex++; // index changes only if no node was deleted
    }
    currentNode = currentNode.getNextNode(); // will work even if it was deleted
  }
return deletedNodes;