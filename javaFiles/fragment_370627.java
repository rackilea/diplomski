public interface Query<ViewT extends View> {
    void run(ViewT view);
}

public Query<TextView> text(final CharSequence str) {
    return new Query<TextView>() {
        public void run(TextView view) {
            view.setText(str);
        }
    };
}