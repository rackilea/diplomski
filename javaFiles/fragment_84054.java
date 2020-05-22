public class TweetView extends CardView implements Observer {

public TweetView(Context context) {
    super(context);
    init();
}

public TweetView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
}

public TweetView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
}

private void init() {
    inflate(getContext(), R.layout.tweet, this);
}