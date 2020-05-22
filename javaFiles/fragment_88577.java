final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setSize(400, 400);
    final Point p = new Point(0, 0);
    shell.addMouseMoveListener(new MouseMoveListener() {

      @Override
      public void mouseMove(MouseEvent e) {

         p.x = e.x;
         p.y = e.y;

         shell.redraw(p.x,p.y,2,2,true);

         for(Control c: shell.getChildren())
         {
           if(c.getBounds().contains(p))
           {
             Point t = e.display.map(shell, c, p);
             p.x = t.x;
             p.y = t.y;
             c.redraw(p.x,p.y,2,2,true);
           }
         }

      }
    });
    PaintListener painter = new PaintListener() {

      @Override
      public void paintControl(PaintEvent e) {

        e.gc.setBackground(e.display.getSystemColor(SWT.COLOR_BLUE));
        e.gc.fillRectangle(p.x, p.y, 2, 2);

      }
    };
    shell.addPaintListener(painter);
    final Label l = new Label(shell, SWT.NONE);
    l.setBounds(10, 10, 60, 40);
    l.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
    l.setText("Label1");
    l.addPaintListener(painter);
    l.addMouseMoveListener(new MouseMoveListener() {

      @Override
      public void mouseMove(MouseEvent e) {


        p.x = e.x;
        p.y = e.y;

        Point t = e.display.map(l, shell, p);

        Rectangle bounds = l.getBounds();
        if(bounds.contains(t))
        {
          l.redraw(p.x,p.y,2,2,true);
        }
        else
        {
          p.x = t.x;
          p.y = t.y;
          shell.redraw(p.x,p.y,2,2,true);
        }
      }
    });

    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();