wrapper1.addContainerListener(new ContainerAdapter() {
    @Override
    public void componentAdded(final ContainerEvent e) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JComponent comp = (JComponent) e.getChild();
                Rectangle bounds = new Rectangle(comp.getBounds());
                comp.scrollRectToVisible(bounds);
            }
        });

    }
});