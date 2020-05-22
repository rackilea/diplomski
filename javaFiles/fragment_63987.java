public void renderSpell(Graphics2D g) {
    AffineTransform transform = g.getTransform();
    for(int i=0; i<waterBolt.length; i++) {
        if (waterBolt[i] != null) {
            g.rotate(Math.toRadian(45), waterBolt[i].x, waterBolt[i].y);
            g.fill(waterBolt[i]);
            g.setTransform(transform); // back to original orientation
        }
    }
}