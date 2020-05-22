float radHalfAngle = ... / 2.0; //See below
float sinVal = Math.Sin(radHalfAngle);
float cosVal = Math.Cos(radHalfAngle);
float xVal = 1.0f * sinVal;
float yVal = 0.0f * sinVal;  //Here for completeness.
float zVal = 0.0f * sinVal;  //Here for completeness.
Quaternion rot = new Quaternion(xVal, yVal, zVal, cosVal);