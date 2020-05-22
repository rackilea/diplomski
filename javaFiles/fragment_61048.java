//...
}else{
  current = current.rightChild;

  if(current == null){
   parent.rightChild  = newNode;
   return;
  } /*begin modification*/ else if (current.b.equalsIgnoreCase(word)) { // check if word already is stored in tree
    ++current.a; // increase counter
  } /*end modification*/
}