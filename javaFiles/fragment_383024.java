import java.lang.Math;

class Vector{
    public double x,y,z,length;
    public Vector unit;

    public static void main(String[]s){
        new Vector(5,5,5);

    }

    public Vector(double x, double y, double z){
        this.length = Math.sqrt(x*x + y*y + z*z);

        this.x=x;
        this.y=y;
        this.z=z;

        this.unit = new Vector(x/length, y/length, z/length, true);
    }

    private Vector(double x, double y, double z, boolean isUnitVector){
        // Temp variable for calculating the length
        double length = Math.sqrt(x*x + y*y + z*z);

        if (isUnitVector){
            this.length = 1;

            this.x=x/length;
            this.y=y/length;
            this.z=z/length;

            this.unit = this;
        }else{
            this.length = Math.sqrt(x*x + y*y + z*z);

            this.x=x;
            this.y=y;
            this.z=z;

            this.unit = new Vector(x/length, y/length, z/length, true);
        }

    }

}