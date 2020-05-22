JComboBox coloredArrowsCombo = myComboBox;
        BufferedImage coloredArrowsImage = null;
        try {
            coloredArrowsImage = ImageIO.read(AppVariables.class.getResource("resources/passed.png"));
        } catch (IOException ex) {
            Logger.getLogger(someClessName.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!(coloredArrowsImage == null)) {
            Icon coloredArrowsIcon = new ImageIcon(coloredArrowsImage);
            Component[] comp = coloredArrowsCombo.getComponents();
            for (int i = 0; i < comp.length; i++) {
                if (comp[i] instanceof MetalComboBoxButton) {
                    MetalComboBoxButton coloredArrowsButton = (MetalComboBoxButton) comp[i];
                    coloredArrowsButton.setComboIcon(coloredArrowsIcon);
                    break;
                }
            }
        }