class MyCanvas {
  protected void doPaint(Graphics g, boolean forPrinter) {
    if(forPrinter){
       if(graphTitle != null){
          g.drawString ("Hello Printer",left+10,top+50);
        } 
    }
  }

  @Override
  public void paint(Graphics g) {
    this.doPaint(g, false);
  }
}

class MyPrintable implements Printable {
    public int print(Graphics g, PageFormat pf, int pageIndex) {
      if (pageIndex != 0)
          return NO_SUCH_PAGE;
      Graphics2D g2 = (Graphics2D) g;
      g2.translate(pf.getImageableX(), pf.getImageableY());

      // If on many pages, this will need to be handled better.
      // But as are ignoring the pageIndex, I assume 
      // you are on a single page and pleased to print everything on it
      canvas.doPaint(g, true);
      return PAGE_EXISTS;
    }
}