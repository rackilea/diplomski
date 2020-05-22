public static void main(String[] args) {
    Display display = new Display();

    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
    Map<String,Control> controlMap = new HashMap<String,Control>();
    final ScrolledComposite scrollComposite = new ScrolledComposite(shell,
        SWT.V_SCROLL | SWT.BORDER);

    final Composite parent = new Composite(scrollComposite, SWT.NONE);
    for (int i = 0; i <= 50; i++) {
      Label label = new Label(parent, SWT.NONE);
      String index = String.valueOf(i);
      controlMap.put(index, label);
      label.setText(index);
    }
    GridLayoutFactory.fillDefaults().numColumns(1).applyTo(parent);

    scrollComposite.setContent(parent);
    scrollComposite.setExpandVertical(true);
    scrollComposite.setExpandHorizontal(true);
    scrollComposite.addControlListener(new ControlAdapter() {
      public void controlResized(ControlEvent e) {
        Rectangle r = scrollComposite.getClientArea();
        scrollComposite.setMinSize(parent.computeSize(r.width,
            SWT.DEFAULT));
      }
    });

    shell.open();

    Control showCntrl = controlMap.get(String.valueOf(5));
    if(showCntrl != null){
      scrollComposite.setOrigin(showCntrl.getLocation());
    }
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }