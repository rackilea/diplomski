private OnFragmentInteractionListener mListener;
      public void onNoData() {
            if (mListener != null) {
                mListener.onFragmentInteraction();
            }
        }
    @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            if (context instanceof OnFragmentInteractionListener) {
                mListener = (OnFragmentInteractionListener) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement OnFragmentInteractionListener");
            }
        }

        @Override
        public void onDetach() {
            super.onDetach();
            mListener = null;
        }

        public interface OnFragmentInteractionListener {

            void onFragmentInteraction();
        }