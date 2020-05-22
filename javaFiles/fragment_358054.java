final Text text = new Text(parent, SWT.BORDER);
text.setEditable(false);

text.addListener(SWT.MouseUp, new Listener() {

    @Override
    public void handleEvent(Event arg0) {
        System.out.println("Event");
        text.setText("new text");
    }
});