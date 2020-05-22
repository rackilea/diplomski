@Override
protected void exportDone(JComponent component,
        Transferable transferable, int action) {
    table = null;
}

@Override
public void exportAsDrag(JComponent comp, InputEvent e, int action) {
    table = (JTable) comp;
    super.exportAsDrag(comp, e, action);
}