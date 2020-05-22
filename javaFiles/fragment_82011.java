public Component findCbo1() {
    for (Component comp : this.getComponents()) {
        if(comp.getName() != null && comp.getName().equals("countryCombo")) {
            return comp;
        }
    }
    return null;
}