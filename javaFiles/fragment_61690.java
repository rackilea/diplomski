@Override
public void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    boolean selected = savedInstanceState.getBoolean(STATE_SELECTED);
    button.setSelected(selected);
    if (selected) // Do some stuff
    else //Do some other stuff
}