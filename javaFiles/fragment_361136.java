@Override
protected void paintChildren(Graphics g) {
    super.paintChildren(g);

    if (action.dragging) {
        g.drawImage(image, p.x, p.y, null);//also notice i use null and not this, unless the class you are using extends ImageObserver no need for this
    }
}