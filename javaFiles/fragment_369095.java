import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.apache.poi.xslf.usermodel.*;
import org.apache.poi.sl.usermodel.*;

import org.openxmlformats.schemas.presentationml.x2006.main.*;
import org.openxmlformats.schemas.drawingml.x2006.main.*;

import java.awt.Dimension;

public class CreatePPTXSheetsBackgroundPicture {

 public static void main(String[] args) throws Exception {

  XMLSlideShow slideShow = new XMLSlideShow();
  XSLFPictureData pictureData = slideShow.addPicture(new FileInputStream("2hGsR.jpg"), PictureData.PictureType.JPEG);
  slideShow.setPageSize(new Dimension(950, 510));

  double imgHeight =  pictureData.getImageDimensionInPixels().getHeight();
  double imgWidth  =  pictureData.getImageDimensionInPixels().getWidth();
  double sildeHeight =  slideShow.getPageSize().getHeight();
  double slideWidth  =  slideShow.getPageSize().getWidth();

  //How to calculate the offset above and below the image
  // imgWidth stretched to slideWidth => ratio = slideWidth / imgWidth
  double ratio = slideWidth / imgWidth;
  // sildeHeight% = 100%
  // imgHeight% = (imgHeight * ratio) * 100% / sildeHeight
  double imgHeightPerCent = (imgHeight * ratio) * 100 / sildeHeight;
  // topMiddle% = (100% - imgHeight%) / 2
  // bottomMiddle% = (100% - imgHeight%) / 2
  // topMiddle+1slideHeight% = (100% - imgHeight%) / 2) - 100%
  // bottomMiddle+1slideHeight% = (100% - imgHeight%) / 2 + 100%
  // topMiddle-1slideHeight% = (100% - imgHeight%) / 2) + 100%
  // bottomMiddle-1slideHeight% = (100% - imgHeight%) / 2 - 100%

  // first slide
  XSLFSlide slide = slideShow.createSlide();
  CTBackgroundProperties backgroundProperties = slide.getXmlObject().getCSld().addNewBg().addNewBgPr();
  CTBlipFillProperties blipFillProperties = backgroundProperties.addNewBlipFill();
  CTRelativeRect ctRelativeRect = blipFillProperties.addNewStretch().addNewFillRect();

  // first slide shows 1 slide above middle of long picture
  // measurement unit is thousandth => percent * 1000
  int top = (int)Math.round(((100 - imgHeightPerCent) / 2 + 100) * 1000);
  int bottom = (int)Math.round(((100 - imgHeightPerCent) / 2 -100) * 1000);
  ctRelativeRect.setT(top);
  ctRelativeRect.setB(bottom);

  String idx = slide.addRelation(null, XSLFRelation.IMAGES, pictureData).getRelationship().getId();
  CTBlip blib = blipFillProperties.addNewBlip();
  blib.setEmbed(idx);

  // second slide
  slide = slideShow.createSlide();
  backgroundProperties = slide.getXmlObject().getCSld().addNewBg().addNewBgPr();
  blipFillProperties = backgroundProperties.addNewBlipFill();
  ctRelativeRect = blipFillProperties.addNewStretch().addNewFillRect();

  // second slide shows middle of long picture
  top = (int)Math.round(((100 - imgHeightPerCent) / 2) * 1000);
  bottom = (int)Math.round(((100 - imgHeightPerCent) / 2) * 1000);
  ctRelativeRect.setT(top);
  ctRelativeRect.setB(bottom);

  idx = slide.addRelation(null, XSLFRelation.IMAGES, pictureData).getRelationship().getId();
  blib = blipFillProperties.addNewBlip();
  blib.setEmbed(idx);

  // third slide
  slide = slideShow.createSlide();
  backgroundProperties = slide.getXmlObject().getCSld().addNewBg().addNewBgPr();
  blipFillProperties = backgroundProperties.addNewBlipFill();
  ctRelativeRect = blipFillProperties.addNewStretch().addNewFillRect();

  // third slide shows 1 slide below middle of long picture
  top = (int)Math.round(((100 - imgHeightPerCent) / 2 - 100) * 1000);
  bottom = (int)Math.round(((100 - imgHeightPerCent) / 2 + 100) * 1000);
  ctRelativeRect.setT(top);
  ctRelativeRect.setB(bottom);

  idx = slide.addRelation(null, XSLFRelation.IMAGES, pictureData).getRelationship().getId();
  blib = blipFillProperties.addNewBlip();
  blib.setEmbed(idx);


  FileOutputStream out = new FileOutputStream("CreatePPTXSheetsBackgroundPicture.pptx");
  slideShow.write(out);
  out.close();
 }
}