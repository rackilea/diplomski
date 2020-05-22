float axisX = ...;
float axisY = ...;
/* Make sure that the length of the vector (axisX, axisY) is 1 (which is 
 * called 'normalised')
 */

float x = axisX;
float y = axisY;

axisX = (float) (x * Math.cos(rotation) - y * Math.sin(rotation));
axisY = (float) (x * Math.sin(rotation) + y * Math.cos(rotation));