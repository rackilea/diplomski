public static interface FillerDataExposer {
    public FillerData exposeFiller();
}

public class MyFragmentHostActivity extends FragmentActivity implements FillerDataExposer {
    private static final String FILLER_KEY = "FILLER_KEY";
    private FillerData myFillerData;

    protected void onCreate(Bundle savedInstance) {
        .......
        if(savedInstance != null) {
            myFillerData = (FillerData) savedInstance.getParcelable(FILLER_KEY);
        } else {
            myFillerData = new FillerData();
        }
    }

    protected void onSaveInstanceState(Bundle savedInstance) {
        super.onSaveInstanceState();
        savedInstance.putExtra(FILLER_KEY, myFillerData);
    }

    public FillerData exposeFiller() {
        return this.myFillerData;
    }
}