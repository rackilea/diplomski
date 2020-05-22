PassArrayList mCallback;


@Override
public void onAttach(Activity activity) {
    super.onAttach(activity);
    mCallback = (PassArrayList) getActivity();
}

@Override
public void onDetach() {
    super.onDetach();
    mCallback = null;
}