try {
    String[] imageatt = new String[]{
            "imageLeftPosition",
            "imageTopPosition",
            "imageWidth",
            "imageHeight"
    };    

    ImageReader reader = (ImageReader)ImageIO.getImageReadersByFormatName("gif").next();
    ImageInputStream ciis = ImageIO.createImageInputStream(new File("house2.gif"));
    reader.setInput(ciis, false);

    int noi = reader.getNumImages(true);
    BufferedImage master = null;

    for (int i = 0; i < noi; i++) { 
        BufferedImage image = reader.read(i);
        IIOMetadata metadata = reader.getImageMetadata(i);

        Node tree = metadata.getAsTree("javax_imageio_gif_image_1.0");
        NodeList children = tree.getChildNodes();

        for (int j = 0; j < children.getLength(); j++) {
            Node nodeItem = children.item(j);

            if(nodeItem.getNodeName().equals("ImageDescriptor")){
                Map<String, Integer> imageAttr = new HashMap<String, Integer>();

                for (int k = 0; k < imageatt.length; k++) {
                    NamedNodeMap attr = nodeItem.getAttributes();
                    Node attnode = attr.getNamedItem(imageatt[k]);
                    imageAttr.put(imageatt[k], Integer.valueOf(attnode.getNodeValue()));
                }
                if(i==0){
                    master = new BufferedImage(imageAttr.get("imageWidth"), imageAttr.get("imageHeight"), BufferedImage.TYPE_INT_ARGB);
                }
                master.getGraphics().drawImage(image, imageAttr.get("imageLeftPosition"), imageAttr.get("imageTopPosition"), null);
            }
        }
        ImageIO.write(master, "GIF", new File( i + ".gif")); 
    }
} catch (IOException e) {
    e.printStackTrace();
}