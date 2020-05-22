private static boolean setText(Label label, String txt, Font font)
  {

    int height = font.getFontData()[0].getHeight();
    GC gc = new GC(label);
    gc.setFont(font);
    Point size = gc.textExtent(txt);
    Rectangle bounds = label.getBounds();
    int diff = bounds.width-size.x;
    if(diff >= 0 || height <=2)
    {
      label.setFont(font);
      label.setText(txt);
      return true;
    }
    else
    {

      String name = font.getFontData()[0].getName();
      int style = font.getFontData()[0].getStyle();
      FontData data = new FontData(name, Math.max(1,height-1), style);
      Font newFont = new Font(Display.getCurrent(), data);
      if(!setText(label, txt, newFont))
      {
        newFont.dispose();
      }
    }
    gc.dispose();
    return false;
  }

  public static void main(String[] args) {



    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setSize(600, 300);

    Label label = new Label(shell, SWT.NONE);
    label.setBounds(20, 20, 100, 50);
    setText(label, "hello stackoverflow!!!!!!", Display.getDefault().getSystemFont());
    shell.open();


    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();


  }