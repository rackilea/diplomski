import java.awt.Polygon;

public class Ship extends Polygon{
    private static final long serialVersionUID = 1L;

    public double center_x = 0;
    public double center_y = 0;

    public double speed_x = 0;
    public double speed_y = 0;

    //the angle of the ship
    public double angle = 0;
    //the acceleration of the ship in the direction defined by angle
    public double acceleration = 0;

    public Ship(int[] x, int[] y, int points, double angle){
        super(x, y, points);
        this.angle= angle;
    }

    public void right(){
        angle += 5;
    }

    public void left(){
        angle -= 5;
    }

    public void move(double timeDiff){
        double a_x = Math.sin(Math.toRadians(angle))*acceleration;
        double a_y = -Math.cos(Math.toRadians(angle))*acceleration;
        center_x = center_x + speed_x*timeDiff + a_x*timeDiff*timeDiff/2;
        center_y = center_y + speed_y*timeDiff + a_y*timeDiff*timeDiff/2;
        speed_x = speed_x + a_x*timeDiff;
        speed_y = speed_y + a_y*timeDiff;

        if(center_x > 300)
            center_x = 0;
        if(center_x < 0)
            center_x = 300;
        if(center_y > 300)
            center_y = 0;
        if(center_y < 0)
            center_y = 300;
    }


    public void reverse(){
        acceleration = -1;
    }

    public void go(){
        acceleration = 1;
    }

    public void stop(){
        acceleration = 0;
    }

    public int getCenterX(){
        return (int) Math.round(center_x);
    }
    public int getCenterY(){
        return (int) Math.round(center_y);
    }

    public double getAng(){
        return angle;
    }

}