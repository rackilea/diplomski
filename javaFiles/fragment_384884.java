private void printStamp()
    {
        long startTime = System.currentTimeMillis();
        if ( panelPhoto.isALabelSelected == false )
            {
                notificationErrorPopup("No stamp is selected !");
            }
        else
            {
                try
                    {
                        String fileName = "C:\\Users\\Admin71\\Desktop\\test1.pdf";
                        int width= panelBasTotal.panelShow.getWidth();
                        int height=panelBasTotal.panelShow.getHeight();
                        final java.awt.Image image = getImageFromPanel(panelBasTotal.panelShow, width, height);

                        Document d = new Document(new com.itextpdf.text.Rectangle (width, height));
                        PdfWriter writer = PdfWriter.getInstance(d, new FileOutputStream(fileName));
                        d.open();

                        Image iTextImage = Image.getInstance(writer, image, 1);
                        iTextImage.setAbsolutePosition(0f, 0f);
                        iTextImage.scalePercent(100);
                        d.add(iTextImage);
                        d.close();
                    }
                catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                System.out.println("Time spent:" + (System.currentTimeMillis() - startTime));
                notificationInfoPopup("Pdf generation finished !");
            }
    }

public static java.awt.Image getImageFromPanel(Component component, int width, int height)
    {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        component.paint(image.getGraphics());
        return image;
    }