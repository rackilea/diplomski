public class MyOnClickListener implements View.OnClickListener {
    private final long nativePeer;

    public MyOnClickListener(final long nativePeer) {
        this.nativePeer = nativePeer;
    }

    @Override
    public void onClick(View v) {
        OnClick(nativePeer);
    }

    @Override
    public void finalize() {
        Release(nativePeer);
    }

    private static native void OnClick(final long peer);
    private static native void Release(final long peer);
}