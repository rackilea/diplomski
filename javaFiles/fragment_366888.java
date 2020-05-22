@Override
public void setBackground(Color bgColor) {
    synchronized (getTreeLock()) {
        if ((bgColor != null) && (bgColor.getAlpha() < 255) && !isUndecorated()) {
            throw new IllegalComponentStateException("The frame is decorated");
        }
        super.setBackground(bgColor);
    }
}