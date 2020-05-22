public abstract class RBArrayAdapter<T> extends ArrayAdapter<T> {
    private Navigator navigator;
    private Toaster toaster;

    public RBArrayAdapter(Activity _activity, int _layout, ArrayList<T> _notes) {
        super(_activity, _layout, _notes);

        navigator = new Navigator(_activity);
        toaster = new Toaster(_activity);
    }


    public Navigator navigate() {
        return navigator;
    }   
}