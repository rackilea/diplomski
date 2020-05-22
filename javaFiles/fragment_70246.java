tri11 = Math.atan(1.0 * offsetDepth / offsetLength); // tri11 is radians
tri1 = tri11 * 180.0 / Math.PI; // tri1 is degrees
marking1 = Math.sqrt(Math.pow(1.0 * offsetLength,2) + Math.pow(1.0 * offsetDepth,2));  
tri2 = (180.0 - tri1) / 2.0; // tri2 is degrees
tri22 = tri2 * Math.PI / 180.0; // tri22 is radians
marking2 = 1.0 * ductDepth / Math.tan(tri22);
// output whatever you like now