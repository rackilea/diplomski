public PlacePickerFragment() {
    super(GraphPlace.class, R.layout.com_facebook_placepickerfragment, args);
}

public void initialize() {
    Bundle args = getArguments();
    setPlacePickerSettingsFromBundle(args);
}