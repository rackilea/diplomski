public Component getComponent(String name) {
    Component component = this.map.get(name);
    if (component instanceof CompositeComponent) {
        ((CompositeComponent)component).init(this);
    }
}