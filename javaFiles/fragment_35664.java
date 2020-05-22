void saveToStack(BufferedImage img){ // makes a copy of img and puts on stack.
    BufferedImage imageForStack = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
    Graphics2D g2d = imageForStack.createGraphics();
    g2d.drawImage(img, 0, 0, null);
    undoStack.push(imageForStack);
}