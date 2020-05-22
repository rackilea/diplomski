public <T extends Component> T getComponent(Class<T> type) {
    for (Component c : this.components) {
        if (type.isAssignableFrom(c.getClass())) {
            return type.cast(c);
        }
    }
    return null;
}