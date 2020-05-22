// get the vector from B to A and normalise it 
BAx = Ax - Bx;
BAy = Ay - By;
leng = Math.sqrt(BAx * BAx + BAy * BAy);
BAx /= leng; // The vector BA is 1 pixel (unit long)
BAy /= leng;