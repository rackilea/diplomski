public final String STATE_SELECTED = "state_selected";
public Button[] buttons; // This is populated elsewhere

@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
    super.onSaveInstanceState(savedInstanceState);
    boolean[] selected = new boolean[buttons.length];
    for (int i = 0; i < buttons.length; i++) selected[i] = buttons[i].isSelected();
    savedInstanceState.putBooleanArray(STATE_SELECTED, selected);
}

@Override
public void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    boolean[] selected = savedInstanceState.getBooleanArray(STATE_SELECTED);
    for (int i = 0; i < buttons.length; i++) button[i].setSelected(selected[i]);
}