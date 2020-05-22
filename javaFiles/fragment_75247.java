// Set callbacks (This is in the onCreate method)
mDoctorAdapter.onRegisterCallbacks(this);

@Override
public void onDoctorChecked(long id) {
    Bundle args = new Bundle();
    args.putLong(SELECTED_DOCTOR_ID, id);
    getSupportLoaderManager().initLoader(SELECTED_DOCTOR_LOADER, args, this);
}