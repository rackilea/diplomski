import java.io.FileInputStream;

import org.apache.poi.hslf.record.Record;
import org.apache.poi.hslf.record.RecordContainer;
import org.apache.poi.hslf.record.RecordTypes;
import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.sl.usermodel.SlideShowFactory;
import org.apache.poi.xslf.usermodel.XSLFSlide;

public class AnimCheck {
    private static final int timingRecordPath[] = {
        RecordTypes.ProgTags.typeID,
        RecordTypes.ProgBinaryTag.typeID,
        RecordTypes.BinaryTagData.typeID,
        0xf144
    };


    public static void main(String[] args) throws Exception {
        SlideShow<?,?> ppt = SlideShowFactory.create(new FileInputStream("no_anim.pptx"));
        Slide<?,?> slide = ppt.getSlides().get(0);
        boolean hasTiming;
        if (slide instanceof XSLFSlide) {
            XSLFSlide xsld = (XSLFSlide)slide;
            hasTiming = xsld.getXmlObject().isSetTiming();
        } else {
            HSLFSlide hsld = (HSLFSlide)slide;
            Record lastRecord = hsld.getSheetContainer();
            boolean found = true;
            for (int ri : timingRecordPath) {
                lastRecord = ((RecordContainer)lastRecord).findFirstOfType(ri);
                if (lastRecord == null) {
                    found = false;
                    break;
                }
            }
            hasTiming = found;
        }
        ppt.close();
        System.out.println(hasTiming);
    }
}