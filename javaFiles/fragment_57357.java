int noPts = width * height / 9;
for (int  i = 0; i < noPts; ++i ){

   fill(#f0e2d7);
   stroke(#f0e2d7);
   point(random(1, width-1), random(1, height-1));
}