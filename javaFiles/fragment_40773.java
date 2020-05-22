JFileChooser chooser = new JFileChooser();

try {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    SwingUtilities.updateComponentTreeUI(chooser);
}
catch (Exception ex) {
    System.out.println(ex);
}