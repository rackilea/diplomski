public class Direction extends Boat {
private double trueWindAngle = 60;
private double trueWindSpeed = 10;
private double apparentWindAngle;
private double apparentWindSpeed;
private double rudPosition = 0;     // rudder position
private double boatSpeed = 4;
private double sailPosition = 0;    // sheet position

// W = true wind speed
// V = boat speed
// lambda = true pointing angle in degrees (0 = upwind, 180 = downwind)
//SOURCE: https://en.wikipedia.org/wiki/Apparent_wind
 public void setApparentWindSpeed() {
    this.apparentWindSpeed = ApparentWindSpeed(getTrueWindSpeed(), getBoatSpeed(), Math.toRadians(trueWindAngle));
}

public double ApparentWindSpeed(double W, double V, double lambda){
    return  Math.sqrt(Math.pow(W,2) + Math.pow(V,2) + 2*W*V*Math.cos(lambda));
}