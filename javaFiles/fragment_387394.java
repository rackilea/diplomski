@Override
public void mouseEntered(MouseEvent e) {
    JMenu item = (JMenu) e.getSource(); // is this implementation
                                        // correct ?
    item.setSelected(true);
};

@Override
public void mouseExited(MouseEvent e) {
    JMenu item = (JMenu) e.getSource();
    item.setSelected(false);
};