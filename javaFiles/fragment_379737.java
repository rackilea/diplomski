protected Object callback;

@Override
@SuppressWarnings({"unchecked"})
public void onAttach(final Context context) {
    super.onAttach(context);
    try {
        this.callback = (Object) getActivity();
    } catch (final ClassCastException e) {
        throw new ClassCastException(context.toString() + " must implement " + this.callback.getClass().getSimpleName());
    }
}