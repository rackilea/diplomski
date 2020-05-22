public class VisibiitySaveTextView extends TextView {
    //These are just keys to save and restore values from the state
    private static final String SUPER_STATE = "super_state";
    private static final String VISIBILITY = "visibility";

    //Constructors

    @Override
    public Parcelable onSaveInstanceState () {
        Bundle state = new Bundle();

        //Piggyback off of the View's implementation and store that
        //bundle of saved information in our container bundle
        state.putParcelable(SUPER_STATE, super.onSaveInstanceState());

        //Store the current visibility of the View in the saved state
        state.putInt(VISIBILITY, getVisibility());
        return state;
    }

    @Override
    public void onRestoreInstanceState (Parcelable state) {
        //state should always be an instance of Bundle since that's what
        //we're saving, but check for safety
        if (state instanceof Bundle) {
            Bundle savedState = (Bundle)state;

            //Set the visibility of the View to match the visibility that
            //we retained in onSavedInstanceState(), falling back to the 
            //current visibility as default if no state was saved
            setVisibility(savedState.getInt(VISIBILITY, getVisibility()));

            //Pull out the superclass state we saved, and let the superclass
            //handle restoring all of the other state
            Parcelable superState = savedState.getParcelable(SUPER_STATE);
            super.onRestoreInstanceState(superState);
        } else {
            //Nothing special to do here other than pass it up to the super
            super.onRestoreInstanceState(state);
        }
    }
}