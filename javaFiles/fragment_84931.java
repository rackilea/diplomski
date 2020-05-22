Ax = 10;   // x of Point A
Ay = 200;  // y of A
Bx = 200;  // x,y of B
By = 200; 
Cx = 40;   // C
Cy = 10;

Dist = 40;  // dist out


BAx = Ax - Bx;
BAy = Ay - By;
BCx = Cx - Bx;
BCy = Cy - By;
leng = Math.sqrt(BAx * BAx + BAy * BAy);
BAx /= leng; 
BAy /= leng;
leng = Math.sqrt(BCx * BCx + BCy * BCy);
BCx /= leng; 
BCy /= leng;

// get inside end points
A1x = Ax - BAy * Dist;
A1y = Ay + BAx * Dist;
C1x = Cx + BCy * Dist;  
C1y = Cy - BCx * Dist;

FBlen = Dist / (BAx * BCy - BAy * BCx); 
FBlen += FBlen * (BAx * BCx + BAy * BCy);
Dx = Bx + BAx * FBlen - BAy * Dist;;
Dy = By + BAy * FBlen + BAx * Dist;