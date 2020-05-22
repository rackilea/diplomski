public class Main extends Fragment{
    Button btn;
    TextView tx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
           Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.main, container, false);
        btn = (Button) rootView.findViewById(R.id.button1);
        tx = (TextView)rootView.findViewById(R.id.newID); //Change your textView ID into different ID
        btn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tx.setText("hello World");
            }
        });
       return rootView;
      }

    }