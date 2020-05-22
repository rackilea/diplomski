public class BKWebView extends WebView {

private Activity yourActivity;

public BKWebView(Context context) {
    super(context);
    // TODO Auto-generated constructor stub
}

public BKWebView(Context context, AttributeSet attrs) {
    super(context, attrs);
    // TODO Auto-generated constructor stub
}

public BKWebView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    // TODO Auto-generated constructor stub
}

@Override
public void invalidate() {
    super.invalidate();

    if (getContentHeight() > 0) {
        // WebView has displayed some content and is scrollable.

        if (yourActivity != null)
            yourActivity.callBackWebView(getContentHeight());

    }
}

/**
 * @param yourActivity the yourActivity to set
 */
public void setYourActivity(Activity yourActivity) {
    this.yourActivity = yourActivity;
}