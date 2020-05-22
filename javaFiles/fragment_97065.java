@Override
public void itemStateChanged(ItemEvent e) {
    JToggleButton b = (JToggleButton) e.getItem();
    if (b.isSelected()) {
        // change icon, color etc.
    } else {
        // restore icon, color etc.
    }
}