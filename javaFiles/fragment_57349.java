final Font arialFont = new Font(Display.getCurrent(), "Arial", 40,
        SWT.NORMAL);
final Font courierFont = new Font(Display.getCurrent(), "Courier New",
        8, SWT.NORMAL);
final Button btn = new Button(parent, SWT.NONE);
btn.setText("New Text");
btn.setSize(100, 30);
btn.setFont(arialFont);
Button changeBtn = new Button(parent, SWT.NONE);
changeBtn.setText("Change Font");
changeBtn.setSize(100, 30);
changeBtn.addSelectionListener(new SelectionListener() {

    @Override
    public void widgetSelected(SelectionEvent arg0) {
        count = count + 1;
        if (count % 2 == 0) {
            btn.getFont().dispose();
            btn.setFont(arialFont);
        } else {
            btn.getFont().dispose();
            btn.setFont(courierFont);
        }
    }

    @Override
    public void widgetDefaultSelected(SelectionEvent arg0) {
        // TODO Auto-generated method stub

    }
});