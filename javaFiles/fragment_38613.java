@Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.list_view, container, false);

      list=(ListView)view.findViewById(R.id.list_view);
      list.setAdapter(new HomeBase(getActivity()));
      Log.v(HOME, "onCreate() was called");

      return view;
 }