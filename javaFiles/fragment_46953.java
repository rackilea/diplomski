JPanel jPanel = jDayChooser1.getDayPanel();

    Component component[] = jPanel.getComponents();

    for (int i = 7; i < 49; i++) {
        component[i].setBackground(Color.red);
    }