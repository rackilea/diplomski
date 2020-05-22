public void registerComponent(JComponent component) {
    component.removeMouseListener(this);
    component.addMouseListener(this);
    component.removeMouseMotionListener(moveBeforeEnterListener);
    component.addMouseMotionListener(moveBeforeEnterListener);
    component.removeKeyListener(accessibilityKeyListener);
    component.addKeyListener(accessibilityKeyListener);
}