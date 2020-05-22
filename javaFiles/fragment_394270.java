public static JMenuBar initializeMenu() {
    // JMenu Bar
    menuBar = new JMenuBar();
    menuBar.setBackground(Color.GRAY);

    // JMenu
    fileMenu = new JMenu("File");
    editMenu = new JMenu("Edit");
    menuBar.add(fileMenu);
    menuBar.add(editMenu);

    // JMenu Items
    jItem = new JMenuItem("Save");
    fileMenu.add(jItem);

    return menuBar;    
}