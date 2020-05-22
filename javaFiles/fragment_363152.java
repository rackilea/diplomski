private Rectangle CreateRectangle(Point pt1, Point pt2)
{
    // we use this method to create the rectangle with positive width and height
    int x1 = Math.Min(pt1.X, pt2.X);
    int y1 = Math.Min(pt1.Y, pt2.Y);


    return new Rectangle(x1, y1, Math.Abs(pt1.X - pt2.X), Math.Abs(pt1.Y - pt2.Y));
}