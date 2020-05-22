// Add observer for doctor
mDoctorAdapter.registerDataSetObserver(new DataSetObserver() {
    @Override
    public void onChanged() {
        if(!systemEntered && mDoctorAdapter.getSelectedDoctorId() != 0){
            Cursor c = getContentResolver().query(
                    DoctorEntry.buildDoctorUri(mDoctorAdapter.getSelectedDoctorId()),
                    DOCTOR_COLUMNS,
                    null,
                    null,
                    null
            );
            systemEntered = true;
            mDoctorAdapter.swapCursor(c);
            systemEntered = false;
        }
    }
});