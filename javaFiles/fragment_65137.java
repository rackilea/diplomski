public NewJFrame() {
    initComponents();
    List<Component> l = new ArrayList<>();
    addComponents(this, l);
    System.out.println("l = " + l);
}

public void addComponents(Container c, List<Component> l) {
    Component ca[] = c.getComponents();
    l.addAll(Arrays.asList(ca));
    for (int i = 0; i < ca.length; i++) {
        Component component = ca[i];
        if (Container.class.isAssignableFrom(component.getClass())) {
            addComponents((Container) component, l);
        }
    }
}