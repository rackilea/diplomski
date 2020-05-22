public class MenuAddressFragment extends Fragment {
private Button gunakanAlamat;

private String nameUser_;
// the rest...

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_menu_address, container, false);

    AdapterGetAddress adapter = new AdapterGetAddress(getActivity, list, new ItemClickedCallback() {
        @Override
        public void onItemClicked(String userName //, the rest..) {

       // assign to the class variable like this
            nameUser_ = userName;
            //  the rest..

        }
    }););
    gunakanAlamat = view.findViewById(R.id.gunakanAlamat);
    gunakanAlamat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Use the data as you want..
        }
    });

    return view;
}