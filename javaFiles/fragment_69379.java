public class DialogFragmentOtherMedia extends DialogFragment {

    int dialogResult;

    //The interface is important!
    public interface YesNoListener {
        void onYesOtherMedia(int output);

        void onNoOtherMedia(int output);
    }

    //Checking for ClassCastException is nice here.
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof YesNoListener)) {
            throw new ClassCastException(activity.toString() + " must implement     YesNoListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialogResult = 0;

        final String mediaType[] = {getString(R.string.Ringtones),getString(R.string.Music),getString(R.string.Alarms)};


        return new AlertDialog.Builder(getActivity())
                .setTitle(getString(R.string.Select_Other_Media_Type))
                .setSingleChoiceItems(mediaType, dialogResult, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Log.d("DialogFragmentOtherMedia.onCreateDialog","Item clicked: " + mediaType[which]);

                        dialogResult = which;
                    }
                })
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Casting the activity to YesNoListener is very important here!  
                        //You'll register the listener in the activity later, by implementing the interface.
                        ((YesNoListener) getActivity()).onYesOtherMedia(dialogResult);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Same thing for your other callbacks.
                        ((YesNoListener) getActivity()).onNoOtherMedia(dialogResult);
                    }
                })
                .create();
    }
}