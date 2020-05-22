import java.io.FileOutputStream;

import org.apache.poi.xslf.usermodel.*;
import org.apache.poi.sl.usermodel.*;

import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;

import java.awt.Rectangle;
import java.awt.Color;

import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Double;

public class CreatePPTXArcShape {

 private static XSLFAutoShape createArcShape(XSLFSlide slide, Rectangle positionAndSize, 
  int startAngle, int endAngle, Color color) {

  XSLFAutoShape arcShape = ((XSLFSlide)slide).createAutoShape();
  arcShape.setShapeType(ShapeType.ARC);
  arcShape.setLineColor(color);
  arcShape.setAnchor(positionAndSize);

  startAngle = startAngle % 360;
  endAngle = endAngle % 360;

  XmlObject xmlObject = arcShape.getXmlObject();
  CTShape ctShape = (CTShape)xmlObject;
  CTGeomGuideList ctGeomGuideList = ctShape.getSpPr().getPrstGeom().getAvLst();
  CTGeomGuide ctGeomGuide = ctGeomGuideList.addNewGd();
  ctGeomGuide.setName("adj1");
  ctGeomGuide.setFmla("val " + (21600000/360*startAngle));
  ctGeomGuide = ctGeomGuideList.addNewGd();
  ctGeomGuide.setName("adj2");
  ctGeomGuide.setFmla("val " + (21600000/360*endAngle));

  return arcShape;
 }

 public static void main(String[] args) throws Exception {

  SlideShow slideShow = new XMLSlideShow();

  Slide slide = slideShow.createSlide();

  XSLFAutoShape arcShape;

  //circle arcs
  arcShape = createArcShape((XSLFSlide)slide, new Rectangle(100, 100, 100, 100), 
   0, 90, Color.BLUE); //0 degrees = 3 o'clock position, 90 degrees = 6 o'clock position, 
  arcShape = createArcShape((XSLFSlide)slide, new Rectangle(150, 100, 100, 100), 
   180, 0, Color.BLUE); //180 degrees = 9 o'clock position
  arcShape = createArcShape((XSLFSlide)slide, new Rectangle(200, 100, 100, 100), 
   270, 90, Color.BLUE); //270 degrees = 12 o'clock position
  arcShape = createArcShape((XSLFSlide)slide, new Rectangle(300, 100, 100, 100), 
   180+45, 270+45, Color.BLUE); 
  arcShape = createArcShape((XSLFSlide)slide, new Rectangle(400, 100, 100, 100), 
   0, 359, Color.BLUE); 

  //elliptic arcs
  arcShape = createArcShape((XSLFSlide)slide, new Rectangle(100, 250, 100, 50), 
   0, 90, Color.BLUE); 
  arcShape = createArcShape((XSLFSlide)slide, new Rectangle(150, 250, 100, 50), 
   180, 0, Color.BLUE); 
  arcShape = createArcShape((XSLFSlide)slide, new Rectangle(200, 250, 100, 50), 
   270, 90, Color.BLUE); 
  arcShape = createArcShape((XSLFSlide)slide, new Rectangle(300, 250, 100, 50), 
   180+45, 270+45, Color.BLUE); 
  arcShape = createArcShape((XSLFSlide)slide, new Rectangle(400, 250, 100, 50), 
   0, 359, Color.BLUE); 

  //Bézier freeform arcs
  XSLFFreeformShape bezierShape = ((XSLFSlide)slide).createFreeform();
  bezierShape.setLineColor(Color.BLUE);
  Path2D.Double path = new Path2D.Double();
  path.moveTo(100d, 400d); // x = 100px from left of slide, y = 400px from top of slide
  path.curveTo(100d, 400d, 150d, 600d, 200d, 400d); // y of middle point is greater than y of baseline => arc downwards
  bezierShape.setPath(path);

  bezierShape = ((XSLFSlide)slide).createFreeform();
  bezierShape.setLineColor(Color.BLUE);
  path = new Path2D.Double();
  path.moveTo(300d, 400d);
  path.curveTo(300d, 400d, 350d, 200d, 400d, 400d); // y of middle point is less than y of baseline => arc upwards
  bezierShape.setPath(path);

  FileOutputStream out = new FileOutputStream("CreatePPTXArcShape.pptx");
  slideShow.write(out);
  out.close();
 }
}