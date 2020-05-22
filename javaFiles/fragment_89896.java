public class AccordionLayout implements LayoutManager {

    // This "could" be controlled by constraints, but that would assume
    // that more then one component could be expanded at a time
    private Component expanded;

    public void setExpanded(Component expanded) {
        this.expanded = expanded;
    }

    public Component getExpanded() {
        return expanded;
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        Dimension size = minimumLayoutSize(parent);
        if (expanded != null) {
            size.height -= expanded.getMinimumSize().height;
            size.height += expanded.getPreferredSize().height;
        }

        return size;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        int height = 0;
        int width = 0;
        for (Component comp : parent.getComponents()) {
            width = Math.max(width, comp.getPreferredSize().width);
            height += comp.getMinimumSize().height;
        }
        return new Dimension(width, height);
    }

    @Override
    public void layoutContainer(Container parent) {

        Insets insets = parent.getInsets();
        int availableHeight = parent.getHeight() - (insets.top + insets.bottom);
        int x = insets.left;
        int y = insets.top;

        int maxSize = 0;
        Dimension minSize = minimumLayoutSize(parent);
        if (expanded != null) {
            minSize.height -= expanded.getMinimumSize().height;
            // Try an honour the preferred size the expanded component...
            maxSize = Math.max(expanded.getPreferredSize().height, availableHeight - minSize.height);
        }

        int width = parent.getWidth() - (insets.left + insets.right);
        for (Component comp : parent.getComponents()) {
            if (expanded != comp) {
                comp.setSize(width, comp.getMinimumSize().height);
            } else {
                comp.setSize(width, maxSize);
            }
            comp.setLocation(x, y);
            y += comp.getHeight();
        }

    }

}