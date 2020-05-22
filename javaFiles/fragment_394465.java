/**
 * Created by paveld on 1/13/14.
 */
public class CustomListView extends ListView {

    private float touchSlop = 0;
    private float downY = 0;
    private boolean consumeTouchEvents = false;

    public CustomListView(Context context) {
        super(context);
        init();
    }

    public CustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean isHandled = true;
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_MOVE:
                float distance = downY - ev.getY();
                if (!consumeTouchEvents && Math.abs(distance) > touchSlop) {

                    //send CANCEL event to the AbsListView so it doesn't scroll
                    ev.setAction(MotionEvent.ACTION_CANCEL);
                    isHandled = super.onTouchEvent(ev);
                    consumeTouchEvents = true;
                    handleScroll(distance);
                }
                break;
            case MotionEvent.ACTION_DOWN:
                consumeTouchEvents = false;
                downY = ev.getY();
                //fallthrough
            default:
                if (!consumeTouchEvents) {
                    isHandled = super.onTouchEvent(ev);
                }
                break;

        }
        return isHandled;
    }

    private void handleScroll(float distance) {
        if (distance > 0) {
            //scroll up
            if (getFirstVisiblePosition() < getAdapter().getCount() - 1) {
                smoothScrollToPositionFromTop(getFirstVisiblePosition() + 1, 0, 300);
            }
        } else {
            //scroll down
            if (getFirstVisiblePosition() > 0) {
                smoothScrollToPositionFromTop(getFirstVisiblePosition() - 1, 0, 300);
            }
        }
    }
}