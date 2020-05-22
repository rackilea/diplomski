public class ProfileFragment extends Fragment {
  View rootView;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {

rootView = inflater.inflate(R.layout.profile, container, false);

Button button = (Button) rootView.findViewById(R.id.button);
button.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v)
    {
        onButtonClicked(v);
    }
});
return rootView;
 }
  public void onButtonClicked(View view)
  {
   //do your stuff here..
   final FragmentTransaction ft = getFragmentManager().beginTransaction();
   ft.add(R.id.fragmentLayout, new flatview(), "NewFragmentTag");
   ft.commit();
   }