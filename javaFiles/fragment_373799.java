public class ScrollAwareGridView extends GridView {

    /** Callback interface to report immediate scroll changes */
    public interface ImmediateScrollListener {
        void onImmediateScrollChanged();
    }

    /** External listener for  */
    private ImmediateScrollListener mScrollListener = null;

    public ScrollAwareGridView(final Context context) {
        super(context);
    }

    public ScrollAwareGridView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollAwareGridView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onScrollChanged(final int l, final int t, final int oldl, final int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (null != mScrollListener) {
            mScrollListener.onImmediateScrollChanged();
        }
    }

    /**
     * @param listener {@link ImmediateScrollListener}
     */
    public void setImmediateScrollListener(final ImmediateScrollListener listener) {
        mScrollListener = listener;
    }
}