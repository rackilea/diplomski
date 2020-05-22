package kpi.ua.shapes;

public class Cone {
    private Double a;
    private Double b;
    private Double c;
    private Double fi;

    public Cone() {
        super();
    }
    public Cone(Double a, Double b, Double c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Double getA() {
        return a;
    }
    public void setA(Double a) {
        this.a = a;
    }
    public Double getB() {
        return b;
    }
    public void setB(Double b) {
        this.b = b;
    }
    public Double getC() {
        return c;
    }
    public void setC(Double c) {
        this.c = c;
    }
    public Double getFi() {
        return fi;
    }
    public void setFi(Double fi) {
        this.fi = fi;
    }
    public Point3D getPoint(Double fi,Double r){
        Double x=this.a*r*Math.cos(fi);
        Double y=this.b*r*Math.sin(fi);
        Double z=this.c*r;
        return new Point3D(x, y, z);
    }
}