//Rotate Z
double newX = (( x * Math.cos(radz)) - (y * Math.sin(radz)));
y = (( x * Math.sin(radz)) + (y * Math.cos(radz)));
//Ignore Z ###############################################

x = newX;

//Rotate Y
newX = (( x * Math.cos(rady)) + (z * Math.sin(rady)));
//Ignore Y ###############################################
z = (( x * -Math.sin(rady)) + (z * Math.cos(rady)));

x = newX;

//Rotate X 
//Ignore X ###############################################
double newY = (( y * Math.cos(radx)) - (z * Math.sin(radx)));
z = (( y * Math.sin(radx)) + (z * Math.cos(radx)));

y = newY;