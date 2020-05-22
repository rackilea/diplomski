package kpi.ua.shapes;

public class Point3D extends Point {
    private Double z;

    public Point3D(Double x, Double y, Double z) {
        super(x, y);
        this.z = z;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    /**Èçîìåòðèÿ
     * @return
     */
    public Point get2DVision() {
        Double cx=(1.0/Math.sqrt(6))*(Math.sqrt(3)*this.x-Math.sqrt(3)*this.z);
        Double cy=(1.0/Math.sqrt(6))*(Math.sqrt(2)*this.x-Math.sqrt(2)*this.y+Math.sqrt(2)*this.z);
        return new Point(cx, cy);
    }

    @Override
    public String toString() {
        return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
    }


}