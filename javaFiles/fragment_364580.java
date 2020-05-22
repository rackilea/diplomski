private static final Gson gson = new GsonBuilder()
        .registerTypeHierarchyAdapter(RenderedImage.class, getRenderedImageTypeAdapter())
        .create();

public static void main(final String... args)
        throws IOException {
    try ( final InputStream inputStream = getPackageResourceInputStream(Q43301580.class, "sample.png") ) {
        final RenderedImage image = ImageIO.read(inputStream);
        final ImageHolder before = new ImageHolder(image);
        final String json = gson.toJson(before);
        System.out.println(json);
        final ImageHolder after = gson.fromJson(json, ImageHolder.class);
        ...
    }
}