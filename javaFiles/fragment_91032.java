import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class TileDistances
{
    public static void main(String[] args)
    {
        int sizeX = 11;
        int sizeY = 11;
        int centerX = 5;
        int centerY = 5;

        for (int radius=1; radius<5; radius++)
        {
            System.out.println(
                "Radius "+radius+" around "+centerX+","+centerY);
            List<Point> points = coordinates(centerX, centerY, radius);
            char c = (char)('0'+radius);
            System.out.println(createString(points, sizeX, sizeY, c));
        }
    }

    private static String createString(
        List<Point> points, int sizeX, int sizeY, char c)
    {
        StringBuffer sb = new StringBuffer();
        for (int y=0; y<sizeY; y++)
        {
            for (int x=0; x<sizeX; x++)
            {
                Point p = new Point(x,y);
                if (points.contains(p))
                {
                    sb.append(c);
                }
                else
                {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static List<Point> coordinates(
        int cx, int cy, int r)
    {
        List<Point> coordinates = new ArrayList<Point>();
        int steps = r + r;
        addAll(cx + r, cy + r,  0, -1, steps, coordinates);
        addAll(cx + r, cy - r, -1,  0, steps, coordinates);
        addAll(cx - r, cy - r,  0,  1, steps, coordinates);
        addAll(cx - r, cy + r,  1,  0, steps, coordinates);
        return coordinates;
    }

    private static void addAll(
        int x0, int y0, int dx, int dy, int steps,
        List<Point> coordinates)
    {
        int x = x0;
        int y = y0;
        for (int i=0; i<steps; i++)
        {
            coordinates.add(new Point(x,y));
            x += dx;
            y += dy;
        }
    }
}