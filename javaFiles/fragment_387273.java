public static class PlaceholderFragment extends Fragment {

int counter=0;
TextView display;
Button add;
Button sub;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_main, container,
                        false);

    add = (Button) rootView.findViewById(R.id.bAdd);
    sub = (Button) rootView.findViewById(R.id.bSub);
    display = (TextView) rootView.findViewById(R.id.tvDisplay);

    add.setOnClickListener(new View.OnClickListener() {

       @Override
       public void onClick(View arg0) {
           // TODO Auto-generated method stub
           counter++;
           display.setText("Your Total is " +counter);

       }
    });     

    sub.setOnClickListener(new View.OnClickListener() {

       @Override
       public void onClick(View arg0) {
           // TODO Auto-generated method stub
           counter--;
           display.setText("Your Total is " +counter);
       }

    });

    return rootView;
}


}