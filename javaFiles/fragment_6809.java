static void setRectangle(Rectangle rect){
    rect.Top = p;
    rect.Left = q;
    rect.Width = r;
    rect.Height = s;
}
static void main(String[] args) {
    Rectangle r = new Rectangle(a, b, c, d);
    // At this point r is defined as {a,b,c,d}
    setRectangle(r);
    // At this point r is defined as {p,q,r,s}
}