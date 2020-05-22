healthProgressBar.addChangeListener(e -> {
    if (healthProgressBar.getValue() <= healthProgressBar.getMinimum()) {
        frame5.setVisible(false);
        frame7.setVisible(true);
    }
});