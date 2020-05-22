// pixel size
sz = f*tan(0.5*FOVx)/(0.5*xs);
// x,y screen position [pixels] -> xx,yy [world units]
xx=(x-(0.5*xs))*sz;
yy=(y-(0.5*ys))*sz;
// ray
pos = (xx,yy,0);
dir = pos-focus = (xx,yy,f);
// convert to world GCS
pos = M *pos;
dir = M0*dir;
// normalize
dir = dir / |dir|;