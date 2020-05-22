void DrawCircle(int centerX, int centerY, int radius)
{
    int x,y;
    x=-radius;
    while(x < radius)
    {
        y=sqrt(radius*radius-x*x);
        draw(x+centerX,y+centerY);
        y=-y;
        draw(x+centerX,y+centerY);
        x++;
    }
}