frame.addInternalFrameListener(new InternalFrameAdapter() {
    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        frame = null;
    }
});