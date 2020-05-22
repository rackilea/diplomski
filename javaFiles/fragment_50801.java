for( Point p : pointCollection ){
  distance = haversine(p, newPoint);
  if( distance < targetDistance ){
     .. add new results ...
  }
}