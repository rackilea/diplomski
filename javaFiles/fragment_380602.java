final List<Image> images;
        final Image bigImage = new Image(Display.getCurrent(), combinedWidth, height);
        final GC gc = new GC(bigImage);
        //loop thru all the images while increasing x as necessary:
        int x = 0;
        int y = 0;
        for (Image curImage : images) {
            gc.drawImage(curImage, x, y);
            x += curImage.getBounds().width;
        }
        //very important to dispose GC!!!
                    gc.dispose();
        //now you can use bigImage