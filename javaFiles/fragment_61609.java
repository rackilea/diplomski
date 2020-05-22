public void deselectAllCheckBoxes(Component panel) {
    List<Component> allComponents = fm.getComponentsAsList(panel);

    for (Component c : allComponents) { // Loop through all the components in this panel
        if (c instanceof JCheckBox) { // if a component is a check box, uncheck it.
            ((JCheckBox) c).setSelected(false);
        } else if (c instanceof JPanel) { // if a component is a panel, call this method
            deselectAllCheckBoxes(c);     // recursively.
    }
}