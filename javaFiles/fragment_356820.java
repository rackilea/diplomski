@Override
public void onActivityCreated(Bundle savedInstanceState) {
super.onActivityCreated(savedInstanceState);

DgFirebaseSubComponent.Builder builder = (DgFirebaseSubComponent.Builder)
        ((AttendanceApplication) getActivity().getApplication()).getApplicationComponent()
                .subcomponentBuilders()
                .get(DgFirebaseSubComponent.Builder.class)
                .get();
builder.activityModule(new DgFirebaseSubModule()).build().inject(this);

}