BCx = Cx - Bx;
BCy = Cy - By;
leng = Math.sqrt(BCx * BCx + BCy * BCy);
BCx /= leng; 
BCy /= leng;
C1x = Cx + BCy * Dist;  // move in the opposite direction than from A
C1y = Cy - BCx * Dist;