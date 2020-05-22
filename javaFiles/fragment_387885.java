double Eps = 23.440;
double RA = 312.5175;
double EpsRad = Math.toRadians(Eps);
double RARad = Math.toRadians(RA);
double tmp1 = Math.tan(EpsRad);
double tmp2 = Math.sin(RARad);
double result = Math.atan(tmp1 * tmp2);

System.out.println("in radians: " + result); //-0.30931302106018527
System.out.println("in degrees: " + Math.toDegrees(result));//-17.722330655189765