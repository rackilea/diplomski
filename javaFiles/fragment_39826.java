@Override
protected void init() {
    final String resourceKey = "DYN_IMG_KEY";
    final String queryParm = "id";

    getSharedResources().add(resourceKey, new Resource() {
        @Override
        public IResourceStream getResourceStream() {
            final String query = getParameters().getString(queryParm);

            // generate an image containing the query argument
            final BufferedImage img = new BufferedImage(100, 100,
                    BufferedImage.TYPE_INT_RGB);
            final Graphics2D g2 = img.createGraphics();
            g2.setColor(Color.WHITE);
            g2.drawString(query, img.getWidth() / 2, img.getHeight() / 2);

            // return the image as a PNG stream
            return new AbstractResourceStreamWriter() {
                public String getContentType() {
                    return "image/png";
                }
                public void write(OutputStream output) {
                    try { ImageIO.write(img, "png", output); }
                    catch (IOException ex) { /* never swallow exceptions! */ }
                }
            };
        }
    });

    mountSharedResource("/resource", Application.class.getName() + "/" +
            resourceKey);
}