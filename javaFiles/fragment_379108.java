public class TimelineSettings extends DialogFragment {
ArrayList<Integer> selected_categories = new ArrayList<Integer>();
boolean[] itemsChecked = {false, false, false, false, false, false};


// this interface to communicate with the host activity.

public interface dialoglistener {
    public void onOkay(ArrayList<Integer> selected);
    public void onCancel();
}
dialoglistener mlistener;


//this function is to instantiate the dialoglistener

@Override
public void onAttach(Activity activity) {
    super.onAttach(activity);
    try {
        mlistener = (dialoglistener) activity;
    } catch (ClassCastException e) {
        throw new ClassCastException(activity.toString()
                + " must implement dialogListener");
    }
}