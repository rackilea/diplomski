JViewport headerViewport = new JViewport() {

    @Override
    public void setView(Component view) {
        if (view instanceof JTableHeader) {
            filterHeader.add(view, BorderLayout.NORTH);
            super.setView(filterHeader);
        }
    }
};

scroll.setColumnHeader(headerViewport);