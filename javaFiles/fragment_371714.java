Object value = getModel().getValueAt(row, col);
    if (value.equals(false)) {
        comp.setBackground(Color.red);
    } else if (value.equals(true)) {
        comp.setBackground(Color.green);
    } else {
       comp.setBackground(Color.white);
    }