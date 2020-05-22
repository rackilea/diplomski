Vector3d vector = ... //a vector to be transformed
double x=2, y=0.12;
Matrix3d rotMat = new Matrix3d(1,0,0, 0,1,0, 0,0,1); //identity matrix
rotMat.rotX(x); //rotation on X axis
rotMat.transform(vector);
rotMat.rotY(y); // rotation on Y axis
rotMat.transform(vector);
// the vector should now have both x and y rotation
// transformations applied
System.out.println("Rotated vector :\n" + vector);