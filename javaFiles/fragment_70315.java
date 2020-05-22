public Triangle(Point x, Point y, Point z, byte r, byte g, byte b, double fov)
{
    // This is just an example since I have no idea what your
    // Point class actually looks like
    points = new Point[]{
        new Point(x.getX(), x.getY(), x.getZ()),
        new Point(y.getX(), y.getY(), y.getZ()),
        new Point(z.getX(), z.getY(), z.getZ()),
    };

    m_r = r;
    m_g = g;
    m_b = b;

    FOV = fov;
}