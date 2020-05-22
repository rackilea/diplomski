public JMenuItem add(Action a) {
    JMenuItem mi = createActionComponent(a);
    mi.setAction(a);
    add(mi);
    return mi;
}