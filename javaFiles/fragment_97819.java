backbuffer bmp; // source and target image
struct _color { DWORD rgb; int h,s,v; };    // color entry in (re)color table
_color ld_rgb(DWORD rgb)                    // just RGB -> HSV conversion
    {
    const int _b=0;
    const int _g=1;
    const int _r=2;
    const int _a=3;
    union { DWORD dd; BYTE db[4]; } c;
    double r,g,b,min,max,del,h,s,v,dr,dg,db;
    c.dd=rgb;
    r=c.db[_r]; r/=255.0;
    g=c.db[_g]; g/=255.0;
    b=c.db[_b]; b/=255.0;
    min=r; if (min>g) min=g; if(min>b) min=b;
    max=r; if (max<g) max=g; if(max<b) max=b;
    del=max-min;
    v=max;
    if (del<=0.1) { h=0; s=0; } // grayscale
    else{
        s=del/max;
        dr=(((max-r)/6.0)+(del/2.0))/del;
        dg=(((max-g)/6.0)+(del/2.0))/del;
        db=(((max-b)/6.0)+(del/2.0))/del;
        if      (fabs(r-max)<1e-10) h=db-dg;
        else if (fabs(g-max)<1e-10) h=(1.0/3.0)+dr-db;
        else if (fabs(b-max)<1e-10) h=(2.0/3.0)+dg-dr;
        if (h<0.0) h+=1.0;
        if (h>1.0) h-=1.0;
        }
    _color ccc;
    ccc.rgb=rgb;
    ccc.h=255.0*h;
    ccc.s=255.0*s;
    ccc.v=255.0*v;
    return ccc;
    }
void recolor() // this is the recolor you want
    {
    // load input jpg file to bmp image
    TJPEGImage *jpg=new TJPEGImage();
    jpg->LoadFromFile("in.jpg");
    bmp.bmp->Assign(jpg);
    bmp.resize(bmp.bmp->Width,bmp.bmp->Height);
    delete jpg;

    // recolor bmp
    int i,x,y,d;
    _color c0,c1;
    List<_color> col;                   // color list
    col.num=0;                          // clear colro list
    for (y=0;y<bmp.ys;y++)              // process all pixels
     for (x=0;x<bmp.xs;x++)
        {
        c0=ld_rgb(bmp.pyx[y][x]);       // pixel color -> hsv

        if ((c0.h==0)&&(c0.s==0))       // compare it to found colors (grayscales)
         for (i=0;i<col.num;i++)
            {
//          i=-1; c1.rgb=0x00202020; break;
            c1=col[i];
            if ((c1.h!=0)||(c1.s!=0)) continue;
            d=abs(c1.v-c0.v);
            if (d<32) { i=-1; break; }  // match found ?
            }
        else                            // compare it to found colors
         for (i=0;i<col.num;i++)
            {
//          i=-1; c1.rgb=0x0000FF00; break;
            c1=col[i];
            if ((c1.h==0)&&(c1.s==0)) continue;
            d=(abs(c1.h-c0.h))+(abs(c1.s-c0.s));
            if (d<50) { i=-1; break; }  // match found ?
            }
        if (i>=0) { c1=c0; col.add(c1); }   // if not add new color
        bmp.pyx[y][x]=c1.rgb;               // recolor;
        }
    bmp.bmp->Canvas->Brush->Style=bsClear;
    bmp.bmp->Canvas->Font->Color=0x00802040;
    bmp.bmp->Canvas->TextOutA(5,0,"Found colors: "+AnsiString(col.num));
    bmp.bmp->Canvas->Brush->Style=bsSolid;
    for (d=16,i=0;i<col.num;i++)
     for (y=d;y<=d+d;y++)
      for (x=d*i+1;(x<d*i+d)&&(x<bmp.xs);x++)
       bmp.pyx[y][x]=col[i].rgb;
    }