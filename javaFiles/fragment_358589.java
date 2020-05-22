void conccircle(int x,int y, int radius,Graphics G) {
G.drawOval(x-radius,y-radius,radius*2,radius*2);
if(radius>=2)
{
    radius=radius/2;
    conccircle(x,y,radius,G);
}}