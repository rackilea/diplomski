public class FirstTabView extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_first_tab_view, container, false);
            return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //set this fragment to your MainActivity
        MainActivity mainActivity = (MainActivity)getActivity();
        mainActivity.setFirstTabView(this);
    }


     //The method I need to call
     public void PostStuff(String caption){

     }
}