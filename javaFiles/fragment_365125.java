import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public final class Quadrilateral extends Polygon {
    private static final long serialVersionUID = 794866732073166739L;
    public final Point p1, p2, p3, p4;
    public final Line l12, l23, l34, l41;

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        super(new int[] { p1.x, p2.x, p3.x, p4.x }, new int[] { p1.y, p2.y,
                p3.y, p4.y }, 4);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.l12 = Quadrilateral.getLine(p1, p2);
        this.l23 = Quadrilateral.getLine(p2, p3);
        this.l34 = Quadrilateral.getLine(p3, p4);
        this.l41 = Quadrilateral.getLine(p4, p1);
    }

    public static Quadrilateral formatted(Quadrilateral quadrilateral, int w,
            int h) {
        return new Quadrilateral(Format.format(quadrilateral.p1, w, h),
                Format.format(quadrilateral.p2, w, h), Format.format(
                        quadrilateral.p3, w, h), Format.format(
                        quadrilateral.p4, w, h));
    }

    public Quadrilateral[][] grid(int x, int y) {
        Point[][] points = new Point[x + 1][y + 1];
        for (int ix = 0; ix <= x; ix++) {
            for (int iy = 0; iy <= y; iy++) {
                points[ix][iy] = this.getPointAt(x, y, ix, iy);
            }
        }
        Quadrilateral[][] qs = new Quadrilateral[x][y];
        for (int ix = 0; ix < x; ix++) {
            for (int iy = 0; iy < y; iy++) {
                qs[ix][iy] = new Quadrilateral(points[ix][iy],
                        points[ix + 1][iy], points[ix + 1][iy + 1],
                        points[ix][iy + 1]);
            }
        }
        return qs;
    }

    public ArrayList<ArrayList<Quadrilateral>> gridList(int x, int y) {
        Point[][] points = new Point[x + 1][y + 1];
        for (int ix = 0; ix <= x; ix++) {
            for (int iy = 0; iy <= y; iy++) {
                points[ix][iy] = this.getPointAt(x, y, ix, iy);
            }
        }
        ArrayList<ArrayList<Quadrilateral>> qs = new ArrayList<>(0);
        for (int ix = 0; ix < x; ix++) {
            qs.add(new ArrayList<>(y));
            for (int iy = 0; iy < y; iy++) {
                qs.get(ix).add(
                        new Quadrilateral(points[ix][iy], points[ix + 1][iy],
                                points[ix + 1][iy + 1], points[ix][iy + 1]));
            }
        }
        return qs;
    }

    public Point getPointAt(int xdiv, int ydiv, int xiter, int yiter) {
        Point n1 = this.getTopPointAt(xdiv, xiter);
        Point n2 = this.getRightPointAt(ydiv, yiter);
        Point n3 = this.getBottomPointAt(xdiv, xiter);
        Point n4 = this.getLeftPointAt(ydiv, yiter);
        Line h = Quadrilateral.getLine(n4, n2);
        Line v = Quadrilateral.getLine(n1, n3);
        return h.intersect(v, n2.x, n1.x);
    }

    public Point getTopPointAt(int div, int iter) {
        Point start = this.p1;
        Point end = this.p2;
        int xdiff = end.x - start.x;
        int ydiff = end.y - start.y;
        int xadd = (int) ((double) xdiff / (double) div) * iter;
        int yadd = (int) ((double) ydiff / (double) div) * iter;
        int x = start.x + xadd;
        int y = start.y + yadd;
        return new Point(x, y);
    }

    public Point getBottomPointAt(int div, int iter) {
        Point start = this.p4;
        Point end = this.p3;
        int xdiff = end.x - start.x;
        int ydiff = end.y - start.y;
        int xadd = (int) ((double) xdiff / (double) div) * iter;
        int yadd = (int) ((double) ydiff / (double) div) * iter;
        int x = start.x + xadd;
        int y = start.y + yadd;
        return new Point(x, y);
    }

    public Point getLeftPointAt(int div, int iter) {
        Point start = this.p4;
        Point end = this.p1;
        int xdiff = end.x - start.x;
        int ydiff = end.y - start.y;
        int xadd = (int) ((double) xdiff / (double) div) * iter;
        int yadd = (int) ((double) ydiff / (double) div) * iter;
        int x = start.x + xadd;
        int y = start.y + yadd;
        return new Point(x, y);
    }

    public Point getRightPointAt(int div, int iter) {
        Point start = this.p3;
        Point end = this.p2;
        int xdiff = end.x - start.x;
        int ydiff = end.y - start.y;
        int xadd = (int) ((double) xdiff / (double) div) * iter;
        int yadd = (int) ((double) ydiff / (double) div) * iter;
        int x = start.x + xadd;
        int y = start.y + yadd;
        return new Point(x, y);
    }

    public static final Line getLine(Point p1, Point p2) {
        if (p1.x < p2.x) {
            return Quadrilateral.getLine(p2, p1);
        } else {
            int x1 = p1.x;
            int x2 = p2.x;
            int y1 = p1.y;
            int y2 = p2.y;
            int xdiff = x2 - x1;
            int ydiff = y2 - y1;
            double m = (double) ydiff / (double) xdiff;
            double b = y1 - m * x1;
            return new Line(m, b);
        }
    }

    public void paint(Graphics g, BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        Quadrilateral[][] grid = this.grid(w, h);
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                g.setColor(new Color(image.getRGB(x, y), true));
                g.fillPolygon(grid[x][y]);
            }
        }
    }
}