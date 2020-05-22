public class PointsIndex {
    private final int width;
    private final int height;
    private final int rows;
    private final int cols;
    private final List<Point> [][] cells;

    @SuppressWarnings("unchecked")
    public PointsIndex (
        int width, int height, int rows, int cols)
    {
        this.width = width;
        this.height = height;
        this.rows = rows;
        this.cols = cols;

        cells = (List<Point> [][])new List<?> [rows][];
        for (int i = 0; i < rows; i++)
            cells [i] = (List<Point> [])new List<?> [cols];
    }

    public void addPoint (int x, int y)
    {
        int r = x * rows / width;
        int c = y * cols / height;

        List <Point> cell = cells [r][c];
        if (cell == null)
        {
            cell = new ArrayList<Point>();
            cells [r][c] = cell;
        }

        cell.add (new Point (x, y));
    }

    public Point [] getPoints (int x, int y, int w, int h)
    {
        int r1 = x * rows / width;
        int r2 = (x + w - 1) * rows / width;
        int c1 = y * cols / height;
        int c2 = (y + h - 1) * cols / height;

        ArrayList<Point> result = new ArrayList<Point>();

        for (int r = r1; r <= r2; r++)
            for (int c = c1; c <= c2; c++)
            {
                List <Point> cell = cells [r][c];
                if (cell != null)
                {
                    if (r == r1 || r == r2 || c == c1 || c == c2)
                    {
                        for (Point p: cell)
                            if (p.x > x && p.x < x + w && p.y > y && p.y < y + h)
                                result.add (p);
                    }
                    else result.addAll (cell);
                }
            }

        return result.toArray(new Point [result.size()]);
    }

    public static void main(String[] args) {
        Random r = new Random ();

        PointsIndex index = new PointsIndex(1000000, 1000000, 100, 100);
        List <Point> points = new ArrayList<Point>(1000000);

        for (int i = 0; i < 1000000; i++)
        {
            int x = r.nextInt(1000000);
            int y = r.nextInt(1000000);

            index.addPoint(x, y);
            points.add (new Point (x, y));
        }

        long t;

        t = System.currentTimeMillis();
        Point [] choosen1 = index.getPoints(456789, 345678, 12345, 23456);
        System.out.println (
            "Fast method found " + choosen1.length + " points in " + 
            (System.currentTimeMillis() - t) + " ms");

        Rectangle rect = new Rectangle (456789, 345678, 12345, 23456);

        List <Point> choosen2 = new ArrayList<Point>();

        t = System.currentTimeMillis();
        for (Point p: points)
        {
            if (rect.contains(p))
                choosen2.add (p);
        }
        System.out.println(
            "Slow method found " + choosen2.size () + " points in " + 
            (System.currentTimeMillis() - t) + " ms");
    }
}