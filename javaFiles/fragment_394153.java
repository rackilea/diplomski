static {
    keyMap = getFieldsByValue(com.vaadin.event.ShortcutAction.KeyCode.class);

    // example
    String name = keyMap.get(23); // should be "A"
}