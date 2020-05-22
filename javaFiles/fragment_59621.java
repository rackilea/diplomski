//This is what will be used to recognize your number of points in the saved bundle.
static final String POINTS = "pointCount";

@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
    // Save your number of points
    savedInstanceState.putInt(POINTS, pointCount);

    super.onSaveInstanceState(savedInstanceState);
}