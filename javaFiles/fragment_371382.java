public class FinalFragment extends AbstractFillerFragment {
    public void collectAllData() {
        DataFiller allDataCollectedObject = dataExposer.exposeFiller();
        // by calling get...() you should have access to collected data.
    }
}