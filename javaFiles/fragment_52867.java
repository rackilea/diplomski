public Box(double l, double w, double h){
    length=l;
    if(l<1.0)
        length=1.0;
    width=w;
    if(w<1.0)
        width=1.0;
    height=h;
    if(h<1.0)
        height=1.0;
}