public class RecyclerViewFragment extends Fragment {
    RecyclerView mRecyclerView;
    RecyclerAdapter mRecyclerAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.recycler_fragment,container,false);

        mRecyclerView= (RecyclerView) view.findViewById(R.id.recycler);
        mRecyclerAdapter=new RecyclerAdapter(getActivity(),getData(),communication);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public static List<Information> getData() {
        List<Information>data=new ArrayList<>();
        String[] names={"ahmed","mohammed"};
        String[] jobs={"sacsd","csscs"};

        for (int i=0;i<names.length;i++){
            Information current=new Information();
            current.name=(names[i]);
            current.job=(jobs[i]);
            data.add(current);
        }
        return data;
    }

    FragmentCommunication communication=new FragmentCommunication() {
        @Override
        public void respond(int position,String name,String job) {
            FragmentB fragmentB=new FragmentB();
            Bundle bundle=new Bundle();
            bundle.putString("NAME",name);
            bundle.putString("JOB",job);
            fragmentB.setArguments(bundle);
            FragmentManager manager=getFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.replace(R.id.dumper,fragmentB).commit();
        }

    };

}

this is the fragmentB where I get the Strings from the Adapter

    public class FragmentB extends Fragment {
    TextView textview;
    TextView textview2;
    String name;
    String job;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name=getArguments().getString("NAME");
        job=getArguments().getString("JOB");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_b,container,false);

        textview= (TextView) view.findViewById(R.id.getName);
        textview2= (TextView) view.findViewById(R.id.getJob);
        textview.setText(name);
        textview2.setText(job);


        return view;

    }


}