public class PlaceholderFragment extends Fragment implements NameChangedListener{

    private TextView textView;

    private String previousName = null;

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        LayoutInflater lf = getActivity().getLayoutInflater();
        View rootView = lf.inflate(R.layout.fragment_frontpage, container,
                false);
        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getActivity());
        previousName = pref.getString("example_text", "");
        textView = (TextView) rootView.findViewById(R.id.NameView);
        textView.setText(previousName);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity)activity).addNameChangedListener(this);
    }

    @Override
    public void nameChanged(String name) {
        // TODO Auto-generated method stub
        if (!name.equals(previousName)) {
            textView.setText(name);
            previousName = name;
        }
    }

}