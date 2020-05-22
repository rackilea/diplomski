boolean areColliding(Circle c1, Circle c2){

   center_distance = sqrt((x1-x2)^2 +(y1-y2)^2);  //this is the distance between the centers of the two circles.

  if((c1.r+c2.r) < center_distance)
           return false;
  else
          return true;

}