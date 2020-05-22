public static SpeechFragment newInstance(String speechString, String buttonString) {
    // Store data to be passed to the fragment in bundle format
    Bundle args = new Bundle();
    args.putString("Speech", speechString);
    args.putString("ButtonTitle", buttonString);

    // Instantiate Speech fragment and set arguments
    SpeechFragment newFragment = new SpeechFragment();
    newFragment.setArguments(args);
    return newFragment;
}