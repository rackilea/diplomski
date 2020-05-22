Composite composite = new Composite(getContainer(), SWT.NONE);
composite.setLayout(new GridLayout());

Canvas drawWidget = new Canvas(composite, SWT.NONE);
drawWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

drawWidget.addPaintListener(new PaintListener() {
    @Override
    public void paintControl(final PaintEvent e) {
        System.out.println("inDrawWidget");
        final Rectangle r = drawWidget.getClientArea();
        e.gc.drawOval(0, 0, r.width, r.height);
    }
});