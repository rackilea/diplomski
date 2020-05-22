import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ddf.EscherComplexProperty;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.hslf.usermodel.HSLFShape;
import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.util.StringUtil;

public class ShapeName {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream("shapeName.ppt");
        HSLFSlideShow ppt = new HSLFSlideShow(is);
        is.close();

        HSLFSlide slide = ppt.getSlides().get(0);

        for (HSLFShape shape : slide.getShapes()) {
            EscherComplexProperty ep = HSLFShape.getEscherProperty(shape.getEscherOptRecord(), EscherProperties.GROUPSHAPE__SHAPENAME);
            String name;
            if (ep != null) {
                name = StringUtil.getFromUnicodeLE(ep.getComplexData());
            } else {
                name = shape.getShapeName()+shape.getShapeId();
            }
            System.out.println(name);
        }

        ppt.close();
    }
}