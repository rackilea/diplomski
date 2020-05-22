if (context instanceof OnFragmentInteractionListener) {
    mListener = (OnFragmentInteractionListener) context;
} else {
    throw new RuntimeException(context.toString() //  Here is your exception
            + " must implement OnFragmentInteractionListener");
}