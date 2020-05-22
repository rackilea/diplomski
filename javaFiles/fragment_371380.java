public abstract class AbstractFillerFragment extends Fragment {
    protected FillerDataExposer dataExposer;

    public void onAttach(Activity act) {
        super.onAttach(act);
        // make sure no ClassCastExceptions
        this.dataExposer = (FillerDataExposer) act;
    }
}