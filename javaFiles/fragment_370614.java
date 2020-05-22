public class home extends Fragment {
    public static home newInstance() {
        return new home();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
         return inflater.inflate(R.layout.fragment_main, container, false);
    }
}