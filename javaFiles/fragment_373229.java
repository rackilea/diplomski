private class MyMouse extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
        JComponent comp = (JComponent) e.getSource();
        comp.requestFocusInWindow();
    }
}