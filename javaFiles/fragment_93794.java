public class MonitoringLabel extends JLabel {

    public MonitoringLabel(Icon image) {
        super(image);
    }

    public void addActionListener(ActionListener listener) {
        listenerList.add(ActionListener.class, listener);
    }

    public void removeActionListener(ActionListener listener) {
        listenerList.remove(ActionListener.class, listener);
    }

    protected void fireActionPerformed() {
        ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
        if (listeners.length > 0) {
            ActionEvent evt = new ActionEvent(this, 0, "stopped");
            for (ActionListener listener : listeners) {
                listener.actionPerformed(evt);
            }
        }
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int w, int h) {
        boolean finished = super.imageUpdate(img, infoflags, x, y, w, h);
        if (!finished) {
            fireActionPerformed();
        }
        return finished;
    }

}