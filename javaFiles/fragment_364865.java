static Icon scale(Icon icon, double scaleFactor, JTree tree) {
    int width = icon.getIconWidth();
    int height = icon.getIconHeight();

    width = (int) Math.ceil(width * scaleFactor);
    height = (int) Math.ceil(height * scaleFactor);

    BufferedImage image =
        new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    Graphics2D g = image.createGraphics();
    g.scale(scaleFactor, scaleFactor);
    icon.paintIcon(tree, g, 0, 0);
    g.dispose();

    return new ImageIcon(image);
}

static void updateIcons(JTree tree) {
    Font defaultFont = UIManager.getFont("Tree.font");
    Font currentFont = tree.getFont();

    double newScale = (double)
        currentFont.getSize2D() / defaultFont.getSize2D();

    DefaultTreeCellRenderer renderer = 
        (DefaultTreeCellRenderer) tree.getCellRenderer();
    renderer.setOpenIcon(
        scale(UIManager.getIcon("Tree.openIcon"), newScale, tree));
    renderer.setClosedIcon(
        scale(UIManager.getIcon("Tree.closedIcon"), newScale, tree));
    renderer.setLeafIcon(
        scale(UIManager.getIcon("Tree.leafIcon"), newScale, tree));

    Collection<Integer> iconSizes = Arrays.asList(
        renderer.getOpenIcon().getIconHeight(),
        renderer.getClosedIcon().getIconHeight(),
        renderer.getLeafIcon().getIconHeight());

    // Convert points to pixels
    Point2D p = new Point2D.Float(0, currentFont.getSize2D());
    FontRenderContext context = 
        tree.getFontMetrics(currentFont).getFontRenderContext();
    context.getTransform().transform(p, p);
    int fontSizeInPixels = (int) Math.ceil(p.getY());

    tree.setRowHeight(
        Math.max(fontSizeInPixels, Collections.max(iconSizes) + 2));
}