//(minX---maxX)
//Non overlap cases:
//a: |----|       
//b:       |----|

//a:       |----|
//b: |----|

public static void intersectOnX(a,b){
  if (b.minX > a.maxX || a.minX > b.maxX)
    return false;//no intersect
  else
    return true;//intersect
}