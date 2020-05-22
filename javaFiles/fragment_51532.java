private String calculateConstraint() {
    String constraint = null;
    LayoutManager lm = dockingSource.getLayout();
    if (lm instanceof BorderLayout) {
        constraint = (String)((BorderLayout)lm).getConstraints(toolBar);
    }
    return (constraint != null) ? constraint : constraintBeforeFloating;
}