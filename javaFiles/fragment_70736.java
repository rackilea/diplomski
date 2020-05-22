private void initComponents() {
    JTabbedPane outer = new JTabbedPane();
    outer.setOpaque(false);
    // ...

    JPanel innerPane = new JPanel();
    innerPane.setOpaque(false);
    innerPane.setLayout(new FlowLayout());

    ButtonGroup group = new ButtonGroup();
    addButton(innerPane, group, new JToggleButton("alta"));    
    addButton(innerPane, group, new JToggleButton("Modificar")).setSelected(true);
    addButton(innerPane, group, new JToggleButton("compraTarifa"));

    outer.addTab("Socios", innerPane);

    // ...
}

private static <T extends AbstractButton> T addButton(Component parent, ButtonGroup group, T btn) {
    group.add(btn);
    parent.add(btn);
    return btn;
}