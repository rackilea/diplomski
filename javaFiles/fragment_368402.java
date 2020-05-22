@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    Bundle bundle = getArguments();
    if(bundle != null) {
        String[] dataA = bundle.getStringArray(EXTRA_DATA_A);
        String[] dataB = bundle.getStringArray(EXTRA_DATA_B);
        ...
    }
}