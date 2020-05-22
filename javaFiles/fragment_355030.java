package kpi.ua.shapes;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

import kpi.ua.util.ControlUtil;
import kpi.ua.util.GraphicUtil;

public class SurfaceBasedOnBuzierCurve {
    private final static Double DEFAULT_STEP_BY_T = 0.05;
    private final static Double DEFAULT_Q = 1.0;
    private final static Double DEFAULT_STEP_BY_FI = 0.15;
    private BezierCurve movingCurve;
    private List<Point3D> buzierPoints;

    public SurfaceBasedOnBuzierCurve() {
        refreshBuzierCurve();
    }

    public List<Point3D> getBuzierPoints() {
        return buzierPoints;
    }

    public void setConePoints(List<Point3D> buzierPoints) {
        this.buzierPoints = buzierPoints;
    }

    public void calcBuzierPoints() {
        this.buzierPoints = new LinkedList<Point3D>();
        Double q = DEFAULT_Q;
        Point movingPoint;
        for(double fi=0.0;fi<Math.PI*2;fi+=DEFAULT_STEP_BY_FI){
            for(double t=0.0;t<=1.0;t+=DEFAULT_STEP_BY_T){
                movingPoint=this.movingCurve.getValue(t);
                Point3D firstPoint =getSurfacePoint(movingPoint, movingPoint, q, fi);
                if(t+DEFAULT_STEP_BY_T<=1){
                    movingPoint=this.movingCurve.getValue(t+DEFAULT_STEP_BY_T);
                    Point3D secondPoint =getSurfacePoint(movingPoint, movingPoint, q, fi);
                    Point3D thirdPoint=getSurfacePoint(movingPoint, movingPoint, q, fi+DEFAULT_STEP_BY_FI);
                    buzierPoints.add(firstPoint);
                    buzierPoints.add(thirdPoint);
                    buzierPoints.add(secondPoint);

                }               
            }
        }
    }

    /**
     * Gets 3DPoint on surface via roating line
     * 
     * @param from
     * @param to
     * @param q
     * @param fi
     * @return
     */
    public Point3D getSurfacePoint(Point from, Point to, Double q, Double fi) {
        Double x = from.getX() + (to.getX() - from.getX()) * q;
        Double y = (from.getY() + (to.getY() - from.getY()) * q) * Math.cos(fi);
        Double z = (from.getY() + (to.getY() - from.getY()) * q) * Math.sin(fi);
        return new Point3D(x, y, z);
    }

    public void drawBuzierSurface(Graphics2D gr) {
        if (buzierPoints == null)
            calcBuzierPoints();
        GraphicUtil.drawTriangulation(gr, buzierPoints);
    }
    public void refreshBuzierCurve(){
        LinkedList<Point> allPoints = new LinkedList<>();
        allPoints.add(new Point(ControlUtil.BUZIER_FIRST_X, ControlUtil.BUZIER_FIRST_Y));
        allPoints.add(new Point(ControlUtil.BUZIER_SECOND_X, ControlUtil.BUZIER_SECOND_Y));
        allPoints.add(new Point(ControlUtil.BUZIER_THIRD_X, ControlUtil.BUZIER_THIRD_Y));
        allPoints.add(new Point(ControlUtil.BUZIER_FOURTH_X, ControlUtil.BUZIER_FOURTH_X));
        allPoints.add(new Point(ControlUtil.BUZIER_FIFTH_X, ControlUtil.BUZIER_FIFTH_X));
        this.movingCurve = new BezierCurve(allPoints);
    }
}