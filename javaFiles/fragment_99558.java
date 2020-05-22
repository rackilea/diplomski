public static double CalculatePolygonArea(List<Vector2D> coordinates)
{
    double area = 0;

    if (coordinates.size() > 2)
    {
        for (int i = 0; i < coordinates.size()-1; i++)
        {
            Vector2D p1, p2;
            p1 = coordinates.get(i);
            p2 = coordinates.get(i + 1);
            area += Math.toRadians(p2.x - p1.x) * (2 + Math.sin(Math.toRadians(p1.y))
               + Math.sin(Math.toRadians(p2.y)));

        }
        area = area * R * R / 2;
    }

    return Math.abs(area);
}