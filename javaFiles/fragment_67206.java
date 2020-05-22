private static void track(JButton component) {
    component.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("Mouse enter ");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("Mouse exit ");
        }
    });
    component.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentShown(ComponentEvent e) {
            checkMouse(component);
        }

        @Override
        public void componentHidden(ComponentEvent e) {
            checkMouse(component);
        }

        @Override
        public void componentResized(ComponentEvent e) {
            checkMouse(component);

        }

        @Override
        public void componentMoved(ComponentEvent e) {
            checkMouse(component);
        }

    });
    component.addHierarchyListener(new HierarchyListener() {
        @Override
        public void hierarchyChanged(HierarchyEvent e) {
            checkMouse(component);
        }
    });

}

private static void checkMouse(JComponent component) {
    Point mousePosition = component.getMousePosition();
    if (component.isShowing() && mousePosition != null) {
        System.out.println("Equivalent mouse enter " + component.getName());
        component.dispatchEvent(new MouseEvent(component, MouseEvent.MOUSE_ENTERED, 0, 0, mousePosition.x,
                mousePosition.y, 0, false));
    } else {
        System.out.println("Equivalent mouse exit " + component.getName());
        component.dispatchEvent(new MouseEvent(component, MouseEvent.MOUSE_EXITED, 0, 0, 0, 0, 0, false));
    }
}