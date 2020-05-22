public void updateProperties(Properties p) {
    model.removeAllElements();
    for (String s: p.stringPropertyNames()) {
        model.addElement(p.getProperty(s));
    }
}