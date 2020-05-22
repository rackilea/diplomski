//read all shapes i.e place holder in array.
  XMLSlideShow ppt = new XMLSlideShow(fin);
          XSLFSlide[] slides = ppt.getSlides();
          XSLFSlide slide1 =slides[0];
         XSLFShape shapes[]= slide1.getShapes();
          for(int i=0;i<shapes.length;i++){
              System.out.println(shapes[i].getShapeName());
          }

// add text to text place holder like this. assuming at index 0 

XSLFShape title = shapes[0];
          XSLFTextShape textShape = (XSLFTextShape) title;
          textShape.clearText();
          XSLFTextParagraph p = textShape.addNewTextParagraph();
          XSLFTextRun r1 = p.addNewTextRun();
          r1.setText("The");
          r1.setFontColor(Color.blue);
          r1.setFontSize(24.);

// replace picture text holder assuming at index2 2 and type autoshape

          XSLFShape pic =  shapes[2];
          java.awt.geom.Rectangle2D anchor = pic.getAnchor();

          byte[] pictureData = IOUtils.toByteArray(
                    new FileInputStream("C:\\Users\\gm807394\\Desktop\\Koala.jpg"));
                int idx = ppt.addPicture(pictureData,
                        XSLFPictureData.PICTURE_TYPE_PNG);
            XSLFPictureShape picture = slide1.createPicture(idx);
            slide1.removeShape(pic);

            picture.setAnchor(anchor);  


  FileOutputStream fos = new FileOutputStream(path);
            ppt.write(fos);
            fos.close();