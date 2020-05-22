// mesure the difference in age of the newest and oldest objects
double agediff = newest.timestamp - oldest.timestamp;

// for any given object :
// 1. color ratio from 0.0=old to 1.0=new
double ratio = (someObject.timestamp - oldest.timestamp) / ageDiff;

// 2. get red and blue values
int red = 255 - (255 * ratio);
int blue = 255 * ratio;

// 3. construct Color
Color objectColor = new Color(red, 0, blue);