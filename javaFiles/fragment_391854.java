List<java.awt.Color> textColors = Arrays.asList(
     Color.BLACK, Color.BLUE, Color.RED);
List<java.awt.Font> textFonts = Arrays.asList(
     new Font("Arial", Font.BOLD, 40), 
     new Font("Courier", Font.BOLD, 40));

java.awt.Color backgroundColor = Color.ORANGE;

Captcha captcha = new Captcha.Builder(200, 50)
    .addText(
        new DefaultTextProducer(), 
        new DefaultWordRenderer(textColors, textFonts))
    .addBackground(new FlatColorBackgroundProducer(backgroundColor))
    .build();