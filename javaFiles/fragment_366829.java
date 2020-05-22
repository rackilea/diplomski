private CheckedChangeCallback callback = null;

public void onAttach(final Activity activity) {
    super.onAttach(activity);
    if (activity instanceof CheckedChangeCallback) {
        this.callback = (CheckedChangeCallback) activity;
    }
}

public void onDetach() {
    super.onDetach();
    callback = null;
}

public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        switchA = (Switch) getView().findViewById(R.id.switchA);

        switchA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                callback.onCheckedChange(isChecked);
            }
        });