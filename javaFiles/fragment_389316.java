public void setPage(String page) {
    layout.show(this, page);
    for (Component comp : getComponents()) {
        if (comp.isVisible()) {
            System.out.println("Activate " + comp);
            comp.requestFocusInWindow();
            break;
        }
    }
}