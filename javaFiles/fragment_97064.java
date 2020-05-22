@Override
public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    JToggleButton b = buttons.get(i);
    if (i > MAX) { // reset i and all the buttons
        for (JToggleButton b : buttons) {
            b.setSelected(false);
        }
        timer.stop();
        i = 0;
    } else {
        b.setSelected(true);
        // play tone i
        i++;
    }
}