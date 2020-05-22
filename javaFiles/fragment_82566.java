ResultPoint pointA = correctPoints(cornerPoints[0], Vertices.TOPLEFT);
ResultPoint pointB = correctPoints(cornerPoints[1], Vertices.BOTTOMLEFT);
ResultPoint pointC = correctPoints(cornerPoints[2], Vertices.TOPRIGHT);
ResultPoint pointD = correctPoints(cornerPoints[3], Vertices.BOTTOMRIGHT);

---
---

private ResultPoint correctPoints(ResultPoint point, Vertices vertice){
  if(vertice.equals(Vertices.TOPLEFT))
      return new ResultPoint(point.getX()+10, point.getY()+5);
  else if(vertice.equals(Vertices.BOTTOMLEFT)){
      return new ResultPoint(point.getX()+10, point.getY()-5);
  }else if(vertice.equals(Vertices.TOPRIGHT)){
      return new ResultPoint(point.getX(), point.getY()+10);
  }else{
      return new ResultPoint(point.getX()-10, point.getY()-5);
  }

}