public ImageDisplayedTest() {
    try {
        URI imageurl = getClass().getResource("hp_small.jpg").toURI();
        loadThis = new File(imageurl);

        demoPann = ImageIO.read(loadThis);
        System.out.println("Success");
    } catch (IOException e) {
        System.out.println(e);
    } catch (URISyntaxException e) {
        System.out.println(e);
    }
}