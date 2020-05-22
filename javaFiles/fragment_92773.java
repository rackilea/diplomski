picture pic0,pic1;
        // pic0 - source img
        // pic1 - output img
    int x,y,h,s,v,px,pn,*p;
    color c;
    // copy source image to output
    pic1=pic0;
    pic1.save("cornbot0.png");
    // create brown stuff mask
    for (y=0;y<pic1.ys;y++)             // scan all H lines
     for (x=0;x<pic1.xs;x++)            // scan actual H line
        {
        c=pic1.p[y][x];                 // get pixel color
        rgb2hsv(c);                     // in HSV
        h=WORD(c.db[picture::_h]);
        s=WORD(c.db[picture::_s]);
        v=WORD(c.db[picture::_v]);
        // Treshold brownish stuff
        if ((abs(h- 20)<10)&&(abs(s-200)<50)) c.dd=255; else c.dd=0;
        pic1.p[y][x]=c;
        }
    pic1.save("cornbot1.png");
    pic1.smooth(10);                    // blur a bit to remove small clusters as marked
    pic1.save("cornbot2.png");

    // compute centers of gravity
    p=new int[pic1.ys];                 // make space for points
    for (y=0;y<pic1.ys;y++)             // scan all H lines
        {
        px=0; pn=0;                     // init center of gravity (avg point) variables
        for (x=0;x<pic1.xs;x++)         // scan actual H line
         if (pic1.p[y][x].dd>=150)      // use marked points only
            {
            px+=x; pn++;                // add it to avg point
            pic1.p[y][x].dd=0x00004080; // mark used points (after smooth) with Aqua
            }
        if (pn)                         // finish avg point computation
            {
            px/=pn;
            pic1.p[y][px].dd=0x00FFFFFF;// mark it by White
            p[y]=px;                    // store result for line regression
            } else p[y]=-1;             // uncomputed value
        }

    // regress line
    approx x0,dx;
    double ee;
    for (x0.init(-pic1.xs,pic1.xs<<1,100,3,&ee); !x0.done; x0.step())   // search x0
     for (dx.init(-10.0   ,+10.0     ,1.0,3,&ee); !dx.done; dx.step())  // search dx
      for (ee=0.0,y=0;y<pic1.ys;y++)                                    // compute actua solution distance to dataset
       if (p[y]!=-1)                                                    // ignore uncomputed values (no brown stuff)
        ee+=fabs(double(p[y])-x0.a-(double(y)*dx.a));
    // render regressed line with Red
  for (y=0;y<pic1.ys;y++)
    {
    x=double(x0.aa+(double(y)*dx.aa));
    if ((x>=0)&&(x<pic1.xs))
     pic1.p[y][x].dd=0x00FF0000;
    }
    pic1.save("cornbot2.png");
    delete[] p;