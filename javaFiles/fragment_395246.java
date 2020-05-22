import org.apache.poi.xslf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;


public class Slideshow {
    public static void main(String[] args) throws IOException {
        //creating presentation
        try (FileOutputStream out = new FileOutputStream("example.ppt");
             XMLSlideShow ppt = new XMLSlideShow();) {
            //getting the slide master object
            XSLFSlideMaster slideMaster = ppt.getSlideMasters().get(0);

            //get the desired slide layout
            XSLFSlideLayout titleLayout = slideMaster.getLayout(SlideLayout.TITLE);

            //creating a slide with title layout
            XSLFSlide slide1 = ppt.createSlide(titleLayout);

            //selecting the place holder in it
            XSLFTextShape title1 = slide1.getPlaceholder(0);
            title1.setText("Text title");
            ppt.write(out);
        }
    }
}