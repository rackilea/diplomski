package kpi.ua.shapes;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

public class BezierCurve {

    private List<Point> allPoints;

    public BezierCurve(List<Point> allPoints) {
        this.allPoints = allPoints;
    }

    public Point getValue(double t) {
        Point result = new Point();
        int i = 0;
        Double x=new Double(0);
        Double y=new Double(0);
        for (Point p : allPoints) {
            x+=p.getX() * b(i, allPoints.size()-1, t);
            y+=p.getY() * b(i, allPoints.size()-1, t);
            i++;
        }
        result.setX(x);
        result.setY(y);
        return result;
    }

    private Double b(int i, int n, double t) {
        return fact(n)* Math.pow(t, i) * Math.pow(1 - t, n - i) / (fact(i) * fact(n - i));
    }

    private int fact(int num) {
        return (num == 0) ? 1 : num * fact(num - 1);
    }

    public void drawCarcass(Graphics2D gr) {
        Double[] x=new Double[allPoints.size()];
        Double[] y=new Double[allPoints.size()];
        int i=0;
        for(Point p:allPoints){
            x[i]=p.getX();
            y[i]=p.getY();
            i++;
        }
      //  gr.drawPolygon(x, y, i);
    }

    public List<Line> getCurve(){
        LinkedList<Line> curve=new LinkedList<Line>();
        Double t=0.0;
        Point prev = getValue(t);
        Point next; 
        while (t <= 1) {
            next =getValue(t);
            curve.add(new Line(prev,next));
           // gr.drawLine(prev.getX(), prev.getY(), next.getX(), next.getY());
            prev = next;
            t += 0.001;
        }
        next = getValue(t);
        curve.add(new Line(prev,next));
        return curve;
        //gr.drawLine(prev.getX(), prev.getY(), next.getX(), next.getY());   
    }
    public void drawCurve(Graphics2D gr){
//        Double t=0.0;
//        Point prev = getValue(t);
//        Point next; 
//        gr.setColor(Color.yellow);
//        gr.setStroke(new BasicStroke(2.5f));
//        while (t <= 1) {
//            next =getValue(t);          
//         //   gr.drawLine(prev.getX(), prev.getY(), next.getX(), next.getY());
//            prev = next;
//            t += 0.001;
//        }
//        next = getValue(t);
       // gr.drawLine(prev.getX(), prev.getY(), next.getX(), next.getY());        
    }


}