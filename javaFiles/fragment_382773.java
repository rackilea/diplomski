for (Field f : this.getClass().getDeclaredFields()) {
    if (JComponent.class.isAssignableFrom(f.getType())) {
        JComponent field = (JComponent) f.get(this);
        components.add(field);
    }
}