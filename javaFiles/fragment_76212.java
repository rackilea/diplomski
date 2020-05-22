FontUIResource f = new FontUIResource("Tahoma", Font.PLAIN, 11);
Enumeration<Object> it = UIManager.getDefaults().keys();

while (it.hasMoreElements()) {
    Object key = it.nextElement();
    if (UIManager.get(key) instanceof FontUIResource) {
        UIManager.put(key, f);
    }
}