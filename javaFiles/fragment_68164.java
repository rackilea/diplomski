private <T extends View> void initComponents(T view) {
    for (ComponentInitializer<? extends View> initializer : this.componentInitializers) {
        T object = (T) view.findViewById(initializer.getResourceId());
        if (object != null) {
            ((ComponentInitializer<T>) initializer).initialize((T) object);
        }
    }
}