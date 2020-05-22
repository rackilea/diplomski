public class ImportFragment extends Fragment {
    ListView listView;
    private Activity activity;

    public ImportFragment(Activity activity) {
        this.activity = activity;
    }    

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_import,container,false);

        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button btn1 = (Button) view.findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, newactivity.class);
                activity.startActivity(intent);
                activity.finish();

            }
        });
    }
}