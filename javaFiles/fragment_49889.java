public static void main(String[] args) {

        BufferedImage sourceImage = null;
        try {
            sourceImage = ImageIO.read(new File("IScSH.jpg"));
        } catch (IOException e) {
        }

        int type = sourceImage.getType();
        int w = sourceImage.getWidth();
        int h = sourceImage.getHeight();
        byte[] pixels = null;
        if (type == BufferedImage.TYPE_3BYTE_BGR) {
            System.out.println("type.3byte.bgr");
            pixels = (byte[]) sourceImage.getData().getDataElements(0, 0, w, h, null);
        }
        try {
            BufferedImage edgesImage = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
            edgesImage.getWritableTile(0, 0).setDataElements(0, 0, w, h, pixels);
            ImageIO.write(edgesImage, "jpg", new File("nvRhP.jpg"));
        } catch (IOException e) {
        }
    }