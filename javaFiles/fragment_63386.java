public class Cau1 extends Fragment {

    public TextView texview1;
    public int pageNumber;
    public Cau1() {
        // Required empty public constructor
    }

    static Cau1 newInstance(int pageNumber) {
        Cau1 f = new Cau1();

        Bundle args = new Bundle();
        args.putInt("num", pageNumber);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt("num");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_, container, false);
        texview1 = (TextView)rootView.findViewById(R.id.textView1);
        texview1.setText("Page " + String.valueOf(pageNumber));
        return rootView;
    }