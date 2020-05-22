package kpi.ua.util;

import kpi.ua.shapes.Point;
import kpi.ua.shapes.Point3D;

public class ControlUtil {
    public static Double scaleX=1.0;
    public static Double scaleY=1.0;
    public static Double scaleZ=1.0;
    public static long serialVersionUID = 45L;
    public static Double AXIS_LENGTH = 200.0;
    public static Point CENTER_AXISES = new Point(300.0, 200.0);
    public static Point3D AXIS_X;
    public static Point3D AXIS_Y;
    public static Point3D AXIS_Z;
    public static Double CONE_PARAMETR_A=4.0;
    public static Double CONE_PARAMETR_B=6.0;
    public static Double CONE_PARAMETR_C=5.0;
    public static Double CONE_START_RADIOUS=25.0;
    public static Double STEP_BY_FI=0.2;
    public static Boolean isDrawCone=false;


//  allPoints.add(new Point(30.0, 10.0));
//  allPoints.add(new Point(300.0, 210.0));
//  allPoints.add(new Point(100.0, 200.0));
//  allPoints.add(new Complex((double) 55.0, (double) 251.0));
//  allPoints.add(new Complex((double) 155.0, (double) 300.0)); 

    public static Double BUZIER_FIRST_X=30.0;
    public static Double BUZIER_FIRST_Y=10.0;

    public static Double BUZIER_SECOND_X=-150.0;
    public static Double BUZIER_SECOND_Y=110.0;

    public static Double BUZIER_THIRD_X=100.0;
    public static Double BUZIER_THIRD_Y=200.0;

    public static Double BUZIER_FOURTH_X=55.0;
    public static Double BUZIER_FOURTH_Y=251.0;

    public static Double BUZIER_FIFTH_X=155.0;
    public static Double BUZIER_FIFTH_Y=300.0;


    static{
        AXIS_X=new Point3D(AXIS_LENGTH, 0.0 ,0.0);
        AXIS_Y=new Point3D(0.0,AXIS_LENGTH, 0.0);
        AXIS_Z=new Point3D(0.0, 0.0, AXIS_LENGTH);
    }
}