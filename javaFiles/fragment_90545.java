Image image = null;
try {
    image = ImageIO.read(new URL("https://c.static-nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/ds8ojj70wtpthbzadaft/air-max-dia-se-shoe-WCG8t5.jpg"));
    System.out.println("Image read");
}
catch (Exception e) {
}