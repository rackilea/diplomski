public class FirstFragment extends Fragment {

    private OnFirstFragmentReadyListener callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented the callback.
        try {
            callback = (OnFirstFragmentReadyListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFirstFragmentReadyListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Notify the parent activity that the fragment is inflated.
        callback.onFirstFragmentReady();
    }

    public interface OnFirstFragmentReadyListener {
        void onFirstFragmentReady();
    }
}