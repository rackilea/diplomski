import acm.graphics.GPen;
import java.awt.Color;
import java.util.ArrayList;

public class FPen{

   private double relativeCenterX;

   private double relativeCenterY;

   private ArrayList<Double> fromX = new ArrayList<Double>();

   private ArrayList<Double> fromY = new ArrayList<Double>();   

   private ArrayList<Double> distX = new ArrayList<Double>();

   private ArrayList<Double> distY = new ArrayList<Double>();   

   public FPen(double rX, double rY, double z){

      relativeCenterX = rX;

      relativeCenterY = rY;

   }

   public void adjustOrigin(double cX, double cY){

      double changeX = relativeCenterX-cX;

      double changeY = relativeCenterY-cY;

      for(int i = 0; i < fromX.size(); i++){

         fromX.set(i,fromX.get(i)+changeX*zoom);

         fromY.set(i,fromY.get(i)-changeY*zoom);

      }

      relativeCenterX = cX;

      relativeCenterY = cY;

   }

   public void clear(){

      fromX.clear();
      fromY.clear();
      distX.clear();
      distY.clear();

   }

   public void drawLine(double fX, double fY, double tX, double tY){

      fromX.add(fX);

      fromY.add(fY);

      distX.add(tX);

      distY.add(tY);

   }

   public GPen returnGPen(Color c){

      GPen pen = new GPen();

      pen.setColor(c);

      for(int i = 0; i < fromX.size(); i++){

         pen.setLocation(fromX.get(i),fromY.get(i));

         pen.drawLine(distX.get(i),distY.get(i));         

      }

      return pen;

   }

}