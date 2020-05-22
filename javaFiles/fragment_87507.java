public void addPicture(File img,double width,double height)
    {

        String imgPath = img.getPath();

        XWPFParagraph p = doc.createParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun r = p.createRun();

        try {
                int format = XWPFDocument.PICTURE_TYPE_JPEG;

                if(imgPath.endsWith(".emf")) format = XWPFDocument.PICTURE_TYPE_EMF;
                else if(imgPath.endsWith(".wmf")) format = XWPFDocument.PICTURE_TYPE_WMF;
                else if(imgPath.endsWith(".pict")) format = XWPFDocument.PICTURE_TYPE_PICT;
                else if(imgPath.endsWith(".jpeg") || imgPath.endsWith(".jpg")) format = XWPFDocument.PICTURE_TYPE_JPEG;
                else if(imgPath.endsWith(".png")) format = XWPFDocument.PICTURE_TYPE_PNG;
                else if(imgPath.endsWith(".dib")) format = XWPFDocument.PICTURE_TYPE_DIB;
                else if(imgPath.endsWith(".gif")) format = XWPFDocument.PICTURE_TYPE_GIF;
                else if(imgPath.endsWith(".tiff")) format = XWPFDocument.PICTURE_TYPE_TIFF;
                else if(imgPath.endsWith(".eps")) format = XWPFDocument.PICTURE_TYPE_EPS;
                else if(imgPath.endsWith(".bmp")) format = XWPFDocument.PICTURE_TYPE_BMP;
                else if(imgPath.endsWith(".wpg")) format = XWPFDocument.PICTURE_TYPE_WPG;
                else {
                    System.err.println("Unsupported picture: " + imgPath +
                            ". Expected emf|wmf|pict|jpeg|png|dib|gif|tiff|eps|bmp|wpg");
                }

                double pageWidth = PAGE_WIDTH - PAGE_MARGIN_LEFT - PAGE_MARGIN_RIGHT;
                double pageHeight = PAGE_HEIGHT - PAGE_MARGIN_TOP;

                if(width > pageWidth)
                {
                    double difference =  width - pageWidth  ;
                    double differenceRatio = difference / width;
                    //System.out.println("Width is resizing. Start width : "+width+" pixel difference : "+difference+" difference ratio :"+differenceRatio);
                    width = (width - (width * differenceRatio));
                    height =  (height - (height * differenceRatio));
                }

                if(height > pageHeight)
                {
                    double difference = ( height - (pageHeight) ) ;
                    double differenceRatio = difference / height;
                    //System.out.println("Height is resizing. Start Height : "+height+" pixel difference : "+difference+" difference ratio :"+differenceRatio);
                    width = (width - (width * differenceRatio));
                    height =  (height - (height * differenceRatio));
                }

                //System.out.println("Width : "+width+" Height : "+height);

                XWPFPicture pic = r.addPicture(new FileInputStream(img), format, imgPath, Units.toEMU(width), Units.toEMU(height));

            } catch (InvalidFormatException ex) {
                Logger.getLogger(WordHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(WordHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
    }