void setEnabled(Component component, boolean enabled) {
    component.setEnabled(enabled);
    if (component instanceof Container) {
        for (Component child : ((Container) component).getComponents()) {
            setEnabled(child, enabled);
        }
    }
}