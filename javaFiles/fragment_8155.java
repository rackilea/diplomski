public static int sizeBelow (Node x, int y) { // y is very ambiguous 
    if (t == null) {// I am guessing t should be x
    return 0;

}else{

    int count = 0; // the number of nodes below the depth barrier y
    int leftDepth = 0; // this will always be 0 since you never alter it
    int rightDepth = 0; // this to

  if(leftDepth < y){ // this will never not go off unless y is 0 
    leftDepth=1+sizeBelow(x.left, y); // we must decrement y
  }else{ // or we will never enter here 
    count=1+sizeBelow(x.left,y);  // this should be + =
  }

  if(rightDepth < y){ // this will also never not go off
    rightDepth= 1+sizeBelow(x.right,y); // y is again not decremented
  }else{ // this will never be reached
    count=1+sizeBelow(x.right,y); // this to
  }
  return count;
}