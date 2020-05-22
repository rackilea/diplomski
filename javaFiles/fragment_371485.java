public TreeNode getNodeReference(String label){

  if(left!=null){ // 1: left is not null
    if(check(left,label)==true) // 2: no match, proceed to 3
        return left;
    left.getNodeReference(label); // 3: called, but why? no side effect, no return.
  }

  if(middle!=null){ // 4
    if(check(middle,label)==true) // 5
       return middle;
    middle.getNodeReference(label); // 6
  }

  if(right!=null) { // 7
    if(check(right,label)==true) // 8
       return right;
    right.getNodeReference(label); // 9
  }

  return null; // 10: and finally we're here and we return null
}