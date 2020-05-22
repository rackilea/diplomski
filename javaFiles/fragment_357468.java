public static class MyScrollPaneLayout extends ScrollPaneLayout {

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim =  super.preferredLayoutSize(parent);
        JScrollPane pane = (JScrollPane) parent;
        Component comp = pane.getViewport().getView();
        Dimension viewPref = comp.getPreferredSize();
        Dimension port = pane.getViewport().getExtentSize();
        // **Edit 2** changed condition to <= to prevent jumping
        if (port.height < viewPref.height) {
            dim.width += pane.getVerticalScrollBar().getPreferredSize().width;
        }
        return dim;
    }

}