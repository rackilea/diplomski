public static int sizeBelow (Node x, int depth) {  
    if (x == null) {
    return 0;

}else{
  int count = 0; 
  if(depth == 0){
    count +=sizeBelow(x.left, (depth - 1)); 
    count +=sizeBelow(x.right, (depth - 1)); 
  }else{  
    count +=1+sizeBelow(x.left,depth);  
    count +=1+sizeBelow(x.right,depth);
  }


  return count;
}