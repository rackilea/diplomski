private MainActivity mainActivity;

@Override
public void onAttach (Activity activity) {
    super.onAttach(activity);
    if (!(activity instanceof MainActivity)) {
        throw new IllegalStateException("Must be attached to an instance of MainActivity!");
    }
    mainActivity = (MainActivity) activity;
}