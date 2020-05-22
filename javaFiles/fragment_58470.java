private void menuPanel() {
    menuBar = new JMenuBar();

    setJMenuBar(menuBar);
    setVisible(true);

    menuBar.add(file);
    menuBar.add(edit);
    menuBar.add(about);

    summary.addActionListener(new SummaryMenuListener());
    //aboutMenuItem.addActionListener(new AboutMenuListener());

    file.add(transaction);
    file.add(summary);
    file.add(exit);
}