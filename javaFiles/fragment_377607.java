void diamond_square(int size)
    {
    picture pic;
    int x,y,xx,yy,xs,ys,d,d2,r;
    for (xs=1;xs<size;xs<<=1); xs>>=1; ys=xs;   // align  to power of 2
    pic.resize(xs+1,ys+1); pic.pf=_pf_u;        // resize image to power of 2 +1
    d=xs; d2=d>>1; r=128;                       // init step,half step and randomness
    Randomize();
    pic.p[ 0][ 0].dd=r;                         // set corners values (should be random but I want this)
    pic.p[ 0][xs].dd=r;
    pic.p[ys][ 0].dd=r;
    pic.p[ys][xs].dd=r;
    for (;d2;d=d2,d2>>=1)                       // subdivide step until full image is filled
        {
        // diamond
        for (y=d2,yy=ys-d2;y<=yy;y+=d)
         for (x=d2,xx=xs-d2;x<=xx;x+=d)
          pic.p[y][x].dd=((pic.p[y-d2][x-d2].dd+pic.p[y-d2][x+d2].dd+pic.p[y+d2][x-d2].dd+pic.p[y+d2][x+d2].dd)>>2)+Random(r);
        // square
        for (y=d2,yy=ys-d2;y<=yy;y+=d)
         for (x=d ,xx=xs-d ;x<=xx;x+=d)
          pic.p[y][x].dd=((pic.p[y][x-d2].dd+pic.p[y][x+d2].dd+pic.p[y-d2][x].dd+pic.p[y+d2][x].dd)>>2)+Random(r);
        for (y=d ,yy=ys-d ;y<=yy;y+=d)
         for (x=d2,xx=xs-d2;x<=xx;x+=d)
          pic.p[y][x].dd=((pic.p[y][x-d2].dd+pic.p[y][x+d2].dd+pic.p[y-d2][x].dd+pic.p[y+d2][x].dd)>>2)+Random(r);
        for (x=d2,xx=xs-d2;x<=xx;x+=d)
            {
            y= 0; pic.p[y][x].dd=((pic.p[y][x-d2].dd+pic.p[y][x+d2].dd+pic.p[y+d2][x].dd)/3)+Random(r);
            y=ys; pic.p[y][x].dd=((pic.p[y][x-d2].dd+pic.p[y][x+d2].dd+pic.p[y-d2][x].dd)/3)+Random(r);
            }
        for (y=d2,yy=ys-d2;y<=yy;y+=d)
            {
            x= 0; pic.p[y][x].dd=((pic.p[y][x+d2].dd+pic.p[y-d2][x].dd+pic.p[y+d2][x].dd)/3)+Random(r);
            x=xs; pic.p[y][x].dd=((pic.p[y][x-d2].dd+pic.p[y-d2][x].dd+pic.p[y+d2][x].dd)/3)+Random(r);
            }
        // adjust randomness
        r=(r*220)>>8; if (r<2) r=2;
        }
    // here pic holds the terrain map
    }