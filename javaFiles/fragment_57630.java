Button myButton = new Button(parent, SWT.NONE);
    myButton.setText("Hello");
    myButton.addPaintListener(new PaintListener() {

        @Override
        public void paintControl(PaintEvent e) {
            e.gc.setForeground(color);

            e.gc.drawText("Hello", 6, 5, SWT.DRAW_TRANSPARENT);
        }
    });