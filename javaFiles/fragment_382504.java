@Override
public void onCreate( Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    readPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,"false");
}