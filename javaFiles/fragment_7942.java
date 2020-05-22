private OnRowInteractionListener mListener;

@Override
public void onAttach(Context context) {
    super.onAttach(context);
    final String contextName = context.class.getSimpleName();
    try {
        mListener = (OnRowInteractionListener) context;
    } catch (ClassCastException e) {
        throw new ClassCastException(contextName + " must implement OnRowInteractionListener");
    }
}