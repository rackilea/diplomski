try {
    mListener = (OnFragmentInteractionListener) activity;
} catch (ClassCastException e) {
    throw new ClassCastException(activity.toString()
            + " must implement OnFragmentInteractionListener");
}