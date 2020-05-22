private DoctorAdapterCallbacks mCallbacks;

viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked && mCallbacks != null){
            mCallbacks.onDoctorChecked(id);
        }
    }
});

public void onRegisterCallbacks(Activity activity){
    mCallbacks = (DoctorAdapterCallbacks) activity;
}

public static interface DoctorAdapterCallbacks{
    void onDoctorChecked(long id);
}