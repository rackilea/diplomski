protected JComboBox createCombo(Object[] shapeIcons) {
    return new JComboBox( shapeIcons ) {

        @Override
        public Dimension getMaximumSize() {
            return getPreferredSize();
        }

    };
}

// usage (keep the default layoutManager of the toolbar)
shapeChooser = createCombo(shapeIcons);
toolBar.add(shapeChooser);
... 
colorChooser = createCombo( colorNames );
toolBar.add(colorChooser)