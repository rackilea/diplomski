public void setDefaultVisibility(JComponent j) {
    defaultVisibility.put(j, j.isVisible());
    for(JComponent c : j.getComponents()) {
        setDefaultVisibility(c);
    }
}