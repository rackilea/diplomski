TeXFormula formula = new TeXFormula(latex);
    // Note: Old interface for creating icons:
    //TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);
    // Note: New interface using builder pattern (inner class):
    TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY).setSize(20).build();
    icon.setInsets(new Insets(5, 5, 5, 5));

    BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = image.createGraphics();
    g2.setColor(Color.white);
    g2.fillRect(0,0,icon.getIconWidth(),icon.getIconHeight());
    JLabel jl = new JLabel();
    jl.setForeground(new Color(0, 0, 0));
    icon.paintIcon(jl, g2, 0, 0);
    File file = new File("Example2.png");
    try {
        ImageIO.write(image, "png", file.getAbsoluteFile());
    } catch (IOException ex) {}