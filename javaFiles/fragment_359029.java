public class FragmentName extends Fragment {

public FragmentName() {
    // Required empty public constructor

}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_name, container, false);

    Button ID = (Button) rootView.findViewById(R.id.buttonID);
    ID.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentName NAME = new FragmentName();
      fragmentTransaction.replace(R.id.main_container, NAME);
        fragmentTransaction.commit();

        }
    });
    return rootView;
  }
}