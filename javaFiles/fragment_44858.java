Stack startRead(Tree tree) {
  // validation check
  if (tree == null || !tree.hasChild()) return null;

  // create Stack to store the lists
  Stack listStack = new Stack();

  // for every child
  List children = tree.getChildren();
  for (Tree child : children) {
    // create a list
    List childList = new ArrayList();

    // store (push) it into stack
    listStack.push(childList);

    // call the recursive
    readIt(child, listStack);
  }

  return listStack;
}

void readIt(Tree tree, Stack listStack) {
  // pick the top list from stack
  List current = (List) listStack.pop();

  // this is the base; if tree has no child don't call this method again.
  if (!tree.hasChild()) {
    // if it's leaf add the value to current list
    current.add(tree.getValue());

    // push it back to stack
    listStack.push(current);
  } else {
    // for every child
    List children = tree.getChildren();
    for (Tree child : children) {
      // IMPORTANT! clone the list (if this fails, clone it yourself)
      // clone is called when the tree is branching
      List childList = current.clone();

      // insert this tree value to list
      childList.add(tree.getValue());

      // push it back
      listStack.push(childList);

      // call again
      readIt(child, listStack);
    }
  }
}