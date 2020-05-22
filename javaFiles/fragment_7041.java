List<Node> path = aStar.findPath();
//a path with intermediate nodes removed
List<Node> filteredPath = new ArrayList<>(path.size());
for(int i=0; i<path.size(); i++) {
    Node current = path.get(i);
    //the first and the last element get into the result in any case
    if(i==0 || i==path.size()-1) {
          filteredPath.add(current);
    } else {
          //for the elements in between we are detecting the direction change
          Node previous = path.get(i-1);
          Node next = path.get(i+1);
          //is the step from the previous node to this one vertical
          boolean isPreviousStepVertical = current.getCol()==previous.getCol();
          //is the step from this node to the next one vertical
          boolean isNextStepVertical = current.getCol()==next.getCol();
          //we only add the nodes for which the direction has changed
          if(isPreviousStepVertical!=isNextStepVertical) {
               filteredPath.add(current);
          }

    } 
}