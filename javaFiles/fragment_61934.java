BufferedImage awtImage = ImageIO.read(new File(PDFProcessing.image));
        PDXObjectImage ximage = new PDPixelMap(document, awtImage);
        float scale = 1.0f; // alter this value to set the image size
        contentStream.drawXObject(ximage,100,400,(ximage.getWidth()*scale,ximage.getHeight()*scale);
        // these three lines are new
        contentStream.setStrokingColor(Color.red);
        contentStream.addRect(100-3, 400-3, ximage.getWidth()*scale+6, ximage.getHeight()*scale+6);
        contentStream.closeAndStroke();

        contentStream.close();