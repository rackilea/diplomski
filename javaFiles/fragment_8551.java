public class HomeFragment extends Fragment {

public HomeFragment(){}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_home, container, false);

    return rootView;
}
}