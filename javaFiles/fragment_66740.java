private JMenuItem createColoredSeparator(Color color){
        JMenuItem separator = new JMenuItem();
        separator.setPreferredSize(new Dimension(50,50)); //Increased to highlight whats happening
        //Imitate the default raised border
        Border raisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED,
                UIManager.getColor("MenuItem.background"),UIManager.getColor("MenuItem.background").darker());
        //Merge the borders with the raised border applied outside of the border concealing part of the background
        separator.setBorder(new CompoundBorder(
                raisedBorder, BorderFactory.createLineBorder(UIManager.getColor("MenuItem.background"), 8)));
        separator.setBackground(color);
        separator.setEnabled(false); //make the item un-clickable so menu doesn't close
        return separator;
    }