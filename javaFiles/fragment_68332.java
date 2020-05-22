public class MyFragment extends Fragment {
    private FragmentCommunicationInterface communication;

    public MyFragment(FragmentCommunicationInterface communication) {
        this.communication = communication;
    }
}