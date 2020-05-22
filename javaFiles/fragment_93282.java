public class ExampleDownloadFragment extends Fragment {
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        setRetainInstance(true);
        new SyncAttestationInfoTask(this).execute();
    }

    public void onComplete() {
        final Activity activity = getActivity();
        if (activity != null && activity instanceof A) {
            ((A) activity).onComplete();
        }
    }
}