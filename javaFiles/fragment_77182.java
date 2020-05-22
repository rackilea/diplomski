public static class JHideableMenuBar extends JMenuBar {

    private boolean hidden;

    public void setHidden(boolean hidden) {
        if (this.hidden == hidden) return;
        this.hidden = hidden;
        revalidate();
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension pref = super.getPreferredSize();
        if (hidden) {
            pref.height = 0;
        }
        return pref;
    }

}