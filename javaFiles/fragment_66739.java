private JMenuItem createColoredSeparator(Color color){
    JMenuItem separator = new JMenuItem();
    separator.setPreferredSize(new Dimension(5,5));
    separator.setBackground(color);
    separator.setEnabled(false); //make the item unclickable so menu doesn't close
    return separator;
}