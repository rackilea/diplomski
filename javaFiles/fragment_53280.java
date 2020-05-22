public class PointCheck
{
    public Map<Point, Rect> pointMap;

    public PointCheck()
    {
        pointMap = new HashMap<>();
    }

    /**
     *  Map all points that contain the rectangle
     * to the rectangle.
     */
    public void addRect(Rect rect)
    {
        for(int i = rect.x; i < rect.x + rect.width; ++i)
        {
            for(int j = rect.y; j < rect.y + rect.height; ++i)
            {
                pointMap.put(new Point(i, j), rect);
            }
        }
    }

    /**
     *  Returns the rectangle clicked, null
     * if there is no rectangle.
     */
    public Rect checkClick(Point click)
    {
        return pointMap.get(click);
    }
}