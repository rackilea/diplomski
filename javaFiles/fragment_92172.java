public class FindPeopleFragment extends Fragment {

public FindPeopleFragment(){}

@Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {

View rootView = inflater.inflate(R.layout.fragment_find_people, container, false);

 Button btn = (Button) rootView.findViewById(R.id.butto);

  btn.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {

        FragementDemo fd = new FragementDemo();


  android.support.v4.app.FragmentTransaction  ft =
 getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fd); // content_frame is your FrameLayout container
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
    }
});

return rootView;
}
  }