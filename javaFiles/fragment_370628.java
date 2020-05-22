public interface Query {
    void run(View view);
}

private abstract class TypedQuery<ViewT extends View> implements Query {
    private final Class<ViewT> viewType;

    private TypedQuery(Class<ViewT> viewType) {
        this.viewType = viewType;
    }

    public final void run(View view) {
        if (viewType.isInstance(view)) {
            runInternal((ViewT) view);
        } else {
            Log.e(TAG, "view " + view + " is not a " + viewType.getSimpleName());
        }
    }

    protected abstract void runInternal(ViewT view);
}

public Query text(final CharSequence str) {
    return new TypedQuery<TextView>(TextView.class) {
        @Override
        protected void runInternal(TextView view) {
            view.setText(str);
        }
    };
}