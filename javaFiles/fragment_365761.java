public Snippet() {
        File f = new File("test.gif");
        ImageReader is = ImageIO.getImageReadersBySuffix("GIF").next();  
        ImageInputStream iis;
        try {
            iis = ImageIO.createImageInputStream(f);
            is.setInput(iis);  
            int images= is.getNumImages(true);
        } catch (IOException e) {
            e.printStackTrace();
        }  
}