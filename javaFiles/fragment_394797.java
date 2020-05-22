private ActivityWithHomeButton parent;

@Override
public void onAttach(Activity activity) {
    super.onAttach(activity);
    try {
        parent = (ActivityWithHomeButton) activity;
    } catch (ClassCastException e) {
        throw new ClassCastException(activity.toString()
                + " must implement ActivityWithHomeButton");
    }
}