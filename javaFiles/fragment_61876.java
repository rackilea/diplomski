public static <T extends Component> List<T> findAllChildren(JComponent component, Class<T> clazz) {
    List<T> lstChildren = new ArrayList<T>(5);
    for (Component comp : component.getComponents()) {
        if (clazz.isInstance(comp)) {
            lstChildren.add((T) comp);
        } else if (comp instanceof JComponent) {
            lstChildren.addAll(findAllChildren((JComponent) comp, clazz));
        }
    }

    return Collections.unmodifiableList(lstChildren);
}