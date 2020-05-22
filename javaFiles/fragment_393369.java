@Override
public void actionPerformed(ActionEvent arg0) {
    if (frame == null || (frame.getParent() == null && !frame.isIconifiable())) {
        // Your exitsing code
    } else {
        frame.setIcon(false);
        frame.setSelected(true);
        frame.moveToFront();
    }