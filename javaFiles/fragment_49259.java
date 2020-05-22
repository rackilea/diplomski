// import statements omitted
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction() .add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    // onCreateOptionsMenu() and onOptionsItemSelected()
    // method remain the same.

    public static class PlaceholderFragment extends Fragment {

        int counter = 0;
        Button add, sub;
        TextView display;

        public PlaceholderFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            add = (Button) rootView.findViewById(R.id.btnAdd);
            sub = (Button) rootView.findViewById(R.id.btnSub);
            display = (TextView) rootView.findViewById(R.id.tvDisplay);

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counter += 1;
                    display.setText("The total is " + counter);
                }
            });

            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counter -= 1;
                    display.setText("The total is " + counter);
                }
            });

            return rootView;
        }
    }
}