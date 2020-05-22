@BindView(R.id.action_bar) ActionBar actionBar;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View fragmentView = inflater.inflate(R.layout.fragment_layout, container, false);
    ButterKnife.bind(this, fragmentView);

    return fragmentView;
}