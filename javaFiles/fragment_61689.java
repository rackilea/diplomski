public final String STATE_SELECTED = "state_selected";

@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
    super.onSaveInstanceState(savedInstanceState);
    savedInstanceState.putBoolean(STATE_SELECTED, button.isSelected());
}