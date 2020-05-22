package org.apache.poi.xslf;

import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;

import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFAutoShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.junit.Test;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

public class TestGradientFill {
    @Test
    public void fill() throws Exception {
        XMLSlideShow ppt = new XMLSlideShow();
        XSLFSlide sl = ppt.createSlide();
        XSLFAutoShape as = sl.createAutoShape();
        as.setShapeType(ShapeType.STAR_12);
        as.setAnchor(new Rectangle2D.Double(100, 100, 100, 100));
        CTShape cs = (CTShape)as.getXmlObject();
        CTGradientFillProperties gFill = cs.getSpPr().addNewGradFill();
        gFill.addNewLin().setAng(1800000);
        CTGradientStopList list = gFill.addNewGsLst();

        // set the start pos
        CTGradientStop stop = list.addNewGs();
        stop.setPos(0);
        stop.addNewSrgbClr().setVal(new byte[]{ (byte)0x94, (byte)0xbd, (byte)0x5e });

        // set the end pos (100000 = 100%)
        stop = list.addNewGs();
        stop.setPos(100000);
        stop.addNewSrgbClr().setVal(new byte[]{ 0,0,0 });

        FileOutputStream fos = new FileOutputStream("gradient.pptx");
        ppt.write(fos);
        fos.close();
    }
}