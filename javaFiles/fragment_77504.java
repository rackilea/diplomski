public class MainDialogFragment extends DialogFragment {
    View dialogLayout;
    List<Communicator> communicators = new ArrayList<>();

    @Override
    public void onAttachFragment(Fragment childFragment) {
        communicators.add((Communicator) childFragment);
    }

    // all the other things from the MainDialogFragment...
}