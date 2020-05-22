public static void applyTo(JComponent component) {
        if (component.getTransferHandler() == null) {
            throw new IllegalStateException("A TransferHandler must be set before calling this method!");
        }
        try {
            component.getDropTarget().addDropTargetListener(new AutoscrollWorkaround(component));
        } catch (TooManyListenersException e) {
            throw new IllegalStateException("Something went wrong! DropTarget should have been " +
                    "SwingDropTarget which accepts multiple listeners", e);
        }
    }