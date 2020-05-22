public TitleBarLayout() {

}

@Override
public void addLayoutComponent(String name, Component comp) {
    if (comp == null) {
        throw new RuntimeException("Component cannot be null ");
    }
    synchronized (comp.getTreeLock()) {

        switch (name) {
        case RIGHT:
            right = comp;
            rightBound = comp.getPreferredSize();
            break;
        case LEFT:
            left = comp;
            leftBound = comp.getPreferredSize();
            break;
        case MIDDLE:
            middle = comp;
            middleBound = comp.getPreferredSize();
            break;
        default:
            Logger.info("Invalid layout option" + name);
            break;
        }
    }
}

@Override
public void removeLayoutComponent(Component comp) {
    // TODO Auto-generated method stub

}

@Override
public Dimension preferredLayoutSize(Container parent) {
    new BorderLayout();
    return null;
}

@Override
public Dimension minimumLayoutSize(Container parent) {
    if (right != null) {
        return right.getSize();
    }
    return new Dimension(16, 16);
}

@Override
public void layoutContainer(Container parent) {
    synchronized (parent.getTreeLock()) {
        refresh();
        Rectangle parentBounds = parent.getBounds();
        System.out.println("Middle Element = " + middleBound);
        /* adjust the right side */
        right.setBounds(parent.getSize().width - rightBound.width, y,
                rightBound.width, rightBound.height);
        /* parent < middle + right */
        if (parentBounds.getWidth() < middleBound.getWidth()
                + rightBound.getWidth()) {
            middle.setBounds(y, y, parentBounds.width - rightBound.width,
                    middleBound.height);

        } else if (parentBounds.getWidth() < leftBound.getWidth()
                + middleBound.getWidth() + rightBound.getWidth()) {
            /* parent < left + middle + right */
            middle.setBounds(parentBounds.width - rightBound.width
                    - middleBound.width, y, middleBound.width,
                    middleBound.height);
            left.setBounds(parentBounds.width - rightBound.width
                    - middleBound.width - leftBound.width, y,
                    leftBound.width, leftBound.height);

        } else {
            /* parent > left + middle + right */
            middle.setBounds(leftBound.width + middleBound.width, y,
                    middleBound.width, middleBound.height);
            left.setBounds(0, y, leftBound.width, leftBound.height);
        }
    }

}

private void refresh() {
    // rightBound = right.getPreferredSize();
    middleBound = middle.getPreferredSize();
    leftBound = left.getPreferredSize();

}

@Override
public String toString() {
    // TODO Auto-generated method stub
    return "This is my layout";
}