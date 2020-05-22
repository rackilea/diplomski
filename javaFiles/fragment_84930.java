// move from B to h using the normal vec of the line BA time the sum 
// of the length FB
hx = Bx + BAx * (FBlen + BgLen);
hy = By + BAy * (FBlen + BgLen);
Dx = hx - BAy * Dist;  // then at 90 deg dist along to D
Dy = hy + BAx * Dist;