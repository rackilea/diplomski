public class MyPoint {

    private String type;

    @JsonIgnore
    public Point point;

    public MyPoint(){
        this.point = new Point();
    }

    public double[] getCoordinates(){
        return new double[] {this.point.getX(), this.point.getY()};
    }

    public void setCoordinates(double[] x){
        if (x.length == 2){
            this.point.setX(x[0]);
            this.point.setY(x[1]);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}