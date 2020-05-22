public Quadrilateral(Point... points){

if((points.length>0)&&(points[0]!=null)){ //make sure to check this condition to allow user to input any number of parameters
point1=points[0];
}

if((points.length>1)&&(points[1]!=null)){
point2=points[1];
}
.
.
}