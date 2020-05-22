Component last = null;
for (Component comp : menu.getComponents()) {
    if (comp instanceof JSeparator && last instanceof JSeparator) {
        menu.remove(comp);
    } else {
        last = comp;
    }
}