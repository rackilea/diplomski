public static void intersect(a,b){
  if (!intersectOnX(a,b))
    return false;//no intersect

  if (!intersectOnY(a,b))
    return false;//no intersect

  if (!intersectOnZ(a,b))
    return false;//no intersect

  return true;//intersect!
}