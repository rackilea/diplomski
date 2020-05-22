public class MyPanel extends JPanel {
    // ...

    private long _openTime = 0;
    private long _closeTime = 0;

    public long getOpenTime() {
        long closed = _closeTime;

        // if the window is still open, use current time...
        if (closed == 0) {
            closed = System.currentTimeMillis();
        }

        return (closed - _openTime);
    }

    public void onWindowOpened(WindowEvent evt) {
        _openTime = System.currentTimeMillis();
    }

    public void onWindowClosed(WindowEvent evt) {
        _closeTime = System.currentTimeMillis();
        System.out.println(getOpenedTime());  // DEBUG
    }
}