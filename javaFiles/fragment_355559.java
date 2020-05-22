private static Image ImgResize(Image srcImg, double w, double h, JLabel pic) {
        @SuppressWarnings("UnusedAssignment")

        BufferedImage resizedImg = null;

        int W = pic.getWidth(), H = pic.getHeight();
        double AR = w / h, nh = 0, nw = 0;

        try {
            if (w > h) {
                nw = W;
                nh = nw / AR;
            } else {
                nh = H;
                nw = nh * AR;
            }

            resizedImg = new BufferedImage((int) nw, (int) nh, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = resizedImg.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(srcImg, 0, 0, (int) nw, (int) nh, null);
            g2.dispose();

            return resizedImg;
        } catch (Exception e) {
            System.out.println(e.toString() + " resize");
        }
        return resizedImg;
    }

    private static int[] ImgPosition(int w, int h, JLabel pic) {
        int W = pic.getWidth(), H = pic.getHeight();
        @SuppressWarnings({"UnusedAssignment", "LocalVariableHidesMemberVariable"})
        int x = 0, y = 0;

        int[] a = new int[2];

        try {
            if (w > h) {
                x = 5;
                y = ((H / 2) - (h / 2));
            } else {
                y = 0;
                x = ((W / 2) - (w / 2)) - 30;
            }

        } catch (Exception e) {
            System.out.println(e.toString() + " position");
        }
        a[0] = x;
        a[1] = y;

        return a;
    }
}