@Override
public void update(Graphics g) { paint(g); }

@Override
public void paint(Graphics g) {
    // no super.paint(g)

    if (offScreenBuffer==null ||
          (! (offScreenBuffer.getWidth(this) == this.size().width
          && offScreenBuffer.getHeight(this) == this.size().height)))
    {
        offScreenBuffer = this.createImage(size().width, size().height);
    }

    Graphics gr = offScreenBuffer.getGraphics();

    // blank the canvas
    gr.setColor(Color.WHITE);
    gr.fillRect(0,0,offScreenBuffer.getWidth(this),offScreenBuffer.getHeight(this));

    // paint the disks
    paintDisks(gr);

    // paint the curser ontop of the disks
    paintCurser(gr);

    g.drawImage(offScreenBuffer, 0, 0, this);   
}