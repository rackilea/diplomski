package kpi.ua.shapes;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

import kpi.ua.util.ControlUtil;
import kpi.ua.util.GraphicUtil;

public class ConeSurface {
    private List<Point3D> conePoints;
    public List<Point3D> getConePoints() {
        return conePoints;
    }
    public void setConePoints(List<Point3D> conePoints) {
        this.conePoints = conePoints;
    }

    public void calcConePoints(){
        Cone cone = new Cone(ControlUtil.CONE_PARAMETR_A, ControlUtil.CONE_PARAMETR_B, ControlUtil.CONE_PARAMETR_C);
        Double r = ControlUtil.CONE_START_RADIOUS;
        conePoints=new LinkedList<Point3D>();
        while (r >= 0) {
            for (double fi = 0; fi < 2 * Math.PI; fi += ControlUtil.STEP_BY_FI) {
                conePoints.add(cone.getPoint(fi, r));
                conePoints.add(cone.getPoint(fi+ControlUtil.STEP_BY_FI, r));
                if(r!=0){
                    conePoints.add(cone.getPoint(fi, r-1));
                }
            }
            r--;
        }
    }
    public void drawCone(Graphics2D gr){
        if(conePoints==null)
            calcConePoints();
        GraphicUtil.drawTriangulation(gr, conePoints);
    }
}