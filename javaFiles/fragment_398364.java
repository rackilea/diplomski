Point touchEv = ...; 
Point circleCenter = ...; 

//the radius of the circle you used to draw the arc
float circleRadius = ...; 
//how far from the arc should a touch point treated as it's on the arc
float maxDiff = getResources().getDimension(R.dimen.max_diff_dp);

//calculate the distance of the touch point from the center of your circle
float dist = Math.pow(touchEv.x-circleCenter.x,2) + Math.pow(touchEv.y-  circleCenter.y,2)
dist = Math.sqrt(dist); 

//We also need the bounding rect of the top half of the circle (the visible arc)
Rect topBoundingRect = new Rect(circleCenter.x - circleRadius,
            circleCenter.y - circleRadius, 
            circleCenter.x + circleRadius,
            circleCenter.y);


if (Math.abs(dist - circleRadius)  <= maxDiff  &&
  topBoundingRect.contains(touchEv.x, touchEv.y)) {
  // the user is touching the arc 

}