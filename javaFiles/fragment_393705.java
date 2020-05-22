class CustomLabelClickListener implements MouseListener {

    String labelText;
    public void MouseLabelClickListner(String text) {
        labelText = text;
    }
...

@Override
        public void mousePressed(MouseEvent mouseEvent) {
            System.out.println(label.getText())
        }
...
}