double my_sqrt(double x) {
    double c,u,v,y,scale=1;
    int k=0;
    if(x<0) return NaN;
    while(x>2  ) { x/=4; scale *=2; k++; }
    while(x<0.5) { x*=4; scale /=2; k--; }
    // rational approximation of sqrt
    u = (x-1)/(x+1); 
    v = u*u;
    c = 2 - v/2*(1 + v/4*(1 + v/2));
    y = 1 + 2*u/(c-u); // = (c+u)/(c-u);
    // one Halley iteration
    y = y*(1+8*x/(3*(3*y*y+x))) // = y*(y*y+3*x)/(3*y*y+x)
    // reconstruct original scale
    return y*scale;
}