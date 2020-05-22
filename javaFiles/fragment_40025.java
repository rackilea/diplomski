public class PieChart
{
    public static void main(String[] args) throws IOException
    {
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        PDPageContentStream cs = new PDPageContentStream(doc, page);

        cs.transform(Matrix.getTranslateInstance(250, 400));

        cs.setNonStrokingColor(Color.yellow);
        drawSlice(cs, 100, 0, 80);
        cs.fill();
        cs.setNonStrokingColor(Color.red);
        drawSlice(cs, 100, 80, 150);
        cs.fill();
        cs.setNonStrokingColor(Color.green);
        drawSlice(cs, 100, 150, 215);
        cs.fill();
        cs.setNonStrokingColor(Color.blue);
        drawSlice(cs, 100, 215, 305);
        cs.fill();
        cs.setNonStrokingColor(Color.ORANGE);
        drawSlice(cs, 100, 305, 360);
        cs.fill();

        cs.close();
        doc.save("piechart.pdf");
        doc.close();
    }

    private static void drawSlice(PDPageContentStream cs, float rad, float startDeg, float endDeg) throws IOException
    {
        cs.moveTo(0, 0);
        List<Float> smallArc = createSmallArc(rad, Math.toRadians(startDeg), Math.toRadians(endDeg));
        cs.lineTo(smallArc.get(0), smallArc.get(1));
        cs.curveTo(smallArc.get(2), smallArc.get(3), smallArc.get(4), smallArc.get(5), smallArc.get(6), smallArc.get(7));
        cs.closePath();
    }

    /**
     *  From https://hansmuller-flex.blogspot.com/2011/10/more-about-approximating-circular-arcs.html
     * 
     *  Cubic bezier approximation of a circular arc centered at the origin, 
     *  from (radians) a1 to a2, where a2-a1 &lt; pi/2.  The arc's radius is r.
     * 
     *  Returns a list with 4 points, where x1,y1 and x4,y4 are the arc's end points
     *  and x2,y2 and x3,y3 are the cubic bezier's control points.
     * 
     *  This algorithm is based on the approach described in:
     *  Aleksas Riškus, "Approximation of a Cubic Bezier Curve by Circular Arcs and Vice Versa," 
     *  Information Technology and Control, 35(4), 2006 pp. 371-378.
     */
    private static List<Float> createSmallArc(double r, double a1, double a2)
    {
        // Compute all four points for an arc that subtends the same total angle
        // but is centered on the X-axis
        double a = (a2 - a1) / 2;
        double x4 = r * Math.cos(a);
        double y4 = r * Math.sin(a);
        double x1 = x4;
        double y1 = -y4;
        double q1 = x1*x1 + y1*y1;

        double q2 = q1 + x1*x4 + y1*y4;
        double k2 = 4/3d * (Math.sqrt(2 * q1 * q2) - q2) / (x1 * y4 - y1 * x4);
        double x2 = x1 - k2 * y1;
        double y2 = y1 + k2 * x1;
        double x3 = x2; 
        double y3 = -y2;

        // Find the arc points' actual locations by computing x1,y1 and x4,y4 
        // and rotating the control points by a + a1

        double ar = a + a1;
        double cos_ar = Math.cos(ar);
        double sin_ar = Math.sin(ar);

        List<Float> list = new ArrayList<Float>();
        list.add((float) (r * Math.cos(a1)));
        list.add((float) (r * Math.sin(a1))); 
        list.add((float) (x2 * cos_ar - y2 * sin_ar)); 
        list.add((float) (x2 * sin_ar + y2 * cos_ar)); 
        list.add((float) (x3 * cos_ar - y3 * sin_ar)); 
        list.add((float) (x3 * sin_ar + y3 * cos_ar)); 
        list.add((float) (r * Math.cos(a2))); 
        list.add((float) (r * Math.sin(a2)));
        return list;
    }
}