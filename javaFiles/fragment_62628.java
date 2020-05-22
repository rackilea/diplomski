@Override
public void drop(DropTargetDropEvent dtde) {
    boolean success = false;
    // Basically, we want to unwrap the present...
    if (dtde.isDataFlavorSupported(PanelDataFlavor.SHARED_INSTANCE)) {
        Transferable transferable = dtde.getTransferable();
        try {
            Object data = transferable.getTransferData(PanelDataFlavor.SHARED_INSTANCE);
            if (data instanceof JPanel) {
                JPanel panel = (JPanel) data;
                DropTargetContext dtc = dtde.getDropTargetContext();
                Component component = dtc.getComponent();
                if (component instanceof JComponent) {
                    Container parent = panel.getParent();
                    if (parent != null) {
                        parent.remove(panel);
                        parent.revalidate();
                        parent.repaint();
                    }
                    ((JComponent) component).add(panel);
                    success = true;
                    dtde.acceptDrop(DnDConstants.ACTION_MOVE);
                    ((JComponent) component).invalidate();
                    ((JComponent) component).repaint();
                } else {
                    success = false;
                    dtde.rejectDrop();
                }
            } else {
                success = false;
                dtde.rejectDrop();
            }
        } catch (Exception exp) {
            success = false;
            dtde.rejectDrop();
            exp.printStackTrace();
        }
    } else {
        success = false;
        dtde.rejectDrop();
    }
    dtde.dropComplete(success);
}