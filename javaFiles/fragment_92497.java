public class UiFragment extends Fragment {

    private RetainedFragment retainedFragment;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainActivity main = (MainActivity) getActivity();
        retainedFragment = main.getRetainedFragment();
    }
}