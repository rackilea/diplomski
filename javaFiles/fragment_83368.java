public static class FocusHelper {
    public static void alterButtons(Component container) {
        if (component instanceof Container) {
            Component[] children = ((Container) component).getComponents();
            for (Component child : children) {
                alterButtons(child);
            }
        } else if (component instanceof JButton) {
            ((JButton) component).setRequestFocusEnabled(true);
        }
    }
}