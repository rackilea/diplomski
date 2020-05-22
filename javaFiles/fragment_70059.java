protected static final int REFRESH = 0;
private Timer timer;
private TimerTask refresher;

private Handler handler = new Handler() {
    public void handleMessage(Message msg) {
        switch (msg.what) {
        case REFRESH:
            /* your code here */
            break;
        default:
            break;
        }
    }
};