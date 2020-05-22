public class MainFragment extends Fragment {


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.activity_am, container, false);
    ImageButton amelia_facebook = (ImageButton)rootView.findViewById(R.id.facebook_am);
    amelia_facebook.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(getActivity(),Facebook.class));
        }

    });
    return rootView;
}

}