public static void SetImageSize(int i, File[] f, JLabel pic) {
        try {
            pic.setSize(new Dimension(610, 695));

            ImageIcon icon = new ImageIcon(f[i].toString());
            Image img = icon.getImage();

            ImageIcon finalIimage = new ImageIcon(ImgResize(img, img.getWidth(pic), img.getHeight(pic), pic));

            xy = ImgPosition(finalIimage.getIconWidth(), finalIimage.getIconHeight(), pic);

            pic.setSize(new Dimension(pic.getWidth(), img.getHeight(pic)));
            pic.setIcon(finalIimage);
        } catch (Exception ex) {
            System.out.println(ex.toString() + "set image size");
        }
    }