public void windowClosing(WindowEvent w) {
        if (toolBar.isFloatable()) {
            if (dragWindow != null)
                dragWindow.setVisible(false);
            floating = false;
            if (floatingToolBar == null)
                floatingToolBar = createFloatingWindow(toolBar);
            if (floatingToolBar instanceof Window) ((Window)floatingToolBar).setVisible(false);
            floatingToolBar.getContentPane().remove(toolBar);
            String constraint = constraintBeforeFloating;
            if (toolBar.getOrientation() == JToolBar.HORIZONTAL) {
                if (constraint == "West" || constraint == "East") {
                    constraint = "North";
                }
            } else {
                if (constraint == "North" || constraint == "South") {
                    constraint = "West";
                }
            }
            if (dockingSource == null)
                dockingSource = toolBar.getParent();
            if (propertyListener != null)
                UIManager.removePropertyChangeListener(propertyListener);
            dockingSource.add(toolBar, constraint);