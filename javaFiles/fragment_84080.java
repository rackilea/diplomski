double theta = Math.atan2(y, x);
// Remember, Z axis = {0, 0, 1};
// pseudo code for the quaternion:
q = { cos(theta/2.0),     // This is the angle component 
      sin(theta/2.0) * 0, // As you can see, the zero components are ignored
      sin(theta/2.0) * 0, // Left them in for clarity.
      sin(theta/2.0) * 1.0};