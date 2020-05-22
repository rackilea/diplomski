public class MyFragment extends Fragment{

@Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.<your xml layout>, container, false);

        //Do your work here
        return view;
    }
}