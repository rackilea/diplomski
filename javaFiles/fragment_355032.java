package kpi.ua.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Iterator;
import java.util.List;

import kpi.ua.shapes.Line;
import kpi.ua.shapes.Line3D;
import kpi.ua.shapes.Point3D;

public class GraphicUtil{
    public static void drawAxis(Graphics2D gr){
        gr.setColor(Color.RED);
        drawLine(gr,new Line3D(new Point3D(0.0,0.0,0.0),ControlUtil.AXIS_X));
        gr.setColor(Color.WHITE);
        gr.drawString("x", ControlUtil.CENTER_AXISES.getX().intValue()+ControlUtil.AXIS_X.get2DVision().getX().intValue()+5,
                ControlUtil.CENTER_AXISES.getY().intValue()-ControlUtil.AXIS_X.get2DVision().getY().intValue());
        gr.setColor(Color.RED);
        drawLine(gr,new Line3D(new Point3D(0.0,0.0,0.0),ControlUtil.AXIS_Y));
        gr.setColor(Color.WHITE);
        gr.drawString("y", ControlUtil.CENTER_AXISES.getX().intValue()+ControlUtil.AXIS_Y.get2DVision().getX().intValue()+5,
                ControlUtil.CENTER_AXISES.getY().intValue()-ControlUtil.AXIS_Y.get2DVision().getY().intValue());
        gr.setColor(Color.RED);     
        drawLine(gr,new Line3D(new Point3D(0.0,0.0,0.0),ControlUtil.AXIS_Z));
        gr.setColor(Color.WHITE);
        gr.drawString("z", ControlUtil.CENTER_AXISES.getX().intValue()+ControlUtil.AXIS_Z.get2DVision().getX().intValue()+5,
                ControlUtil.CENTER_AXISES.getY().intValue()-ControlUtil.AXIS_Z.get2DVision().getY().intValue());
    }
    public static void moveAroundZ(Double fi,List<Point3D> shape){
        Double x;
        Double y;
        if(shape!=null){
            for(Point3D point:shape){
                x=point.getX()*Math.cos(fi)+point.getY()*Math.sin(fi);
                y=point.getX()*Math.sin(fi)-point.getY()*Math.cos(fi);
                point.setX(x);
                point.setY(y);
            }
        }
    }
    public static void moveAroundX(Double fi,List<Point3D> shape){
        Double y;
        Double z;
        if(shape!=null){
            for(Point3D point:shape){
                y=-point.getY()*Math.cos(fi)-point.getZ()*Math.sin(fi);
                z=-point.getY()*Math.sin(fi)+point.getZ()*Math.cos(fi);
                point.setY(y);
                point.setZ(z);
            }
        }
    }
    public static void moveAroundY(Double fi,List<Point3D> shape){
        Double x;
        Double z;       
        if(shape!=null){
            for(Point3D point:shape){
                x=point.getX()*Math.cos(fi)+point.getZ()*Math.sin(fi);
                z=-point.getX()*Math.sin(fi)+point.getZ()*Math.cos(fi);
                point.setX(x);
                point.setZ(z);
            }
        }
    }
    public static void drawLine(Graphics2D gr,Line3D line3D){
        line3D.getFrom().setX(ControlUtil.scaleX*line3D.getFrom().getX());
        line3D.getFrom().setY(ControlUtil.scaleY*line3D.getFrom().getY());
        line3D.getFrom().setZ(ControlUtil.scaleZ*line3D.getFrom().getZ());
        line3D.getTo().setX(ControlUtil.scaleX*line3D.getTo().getX());
        line3D.getTo().setY(ControlUtil.scaleY*line3D.getTo().getY());
        line3D.getTo().setZ(ControlUtil.scaleZ*line3D.getTo().getZ());
        Line line=line3D.get2DVision();
        gr.drawLine((int)Math.round(ControlUtil.CENTER_AXISES.getX()+line.getFrom().getX()), (int)Math.round(ControlUtil.CENTER_AXISES.getY()-line.getFrom().getY()), (int)Math.round(ControlUtil.CENTER_AXISES.getX()+line.getTo().getX()),(int) Math.round(ControlUtil.CENTER_AXISES.getY()-line.getTo().getY()));
    }

    public static void drawTriangulation(Graphics2D gr,List<Point3D> shape){
        if(shape==null)
            return;
        Iterator<Point3D> iter=shape.iterator();
        Point3D from=null;
        Point3D to=null;
        while(iter.hasNext()){
            from=iter.next();
            if(iter.hasNext()){
                to=iter.next();
                GraphicUtil.drawLine(gr, new Line3D(from,to));
                if(iter.hasNext()){
                    from=iter.next();
                    GraphicUtil.drawLine(gr, new Line3D(from,to));                  
                }
            }
        }       
    }
}