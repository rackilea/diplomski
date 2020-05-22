public void mouseClicked(MouseEvent e) {
    JEditorPane editor = (JEditorPane) e.getSource();
    Point pt = new Point(e.getX(), e.getY());
    int pos = editor.viewToModel(pt);
    // whatever you need to do here
}