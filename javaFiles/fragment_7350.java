public class Fragment1 extends Fragment {


    TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        tv = (TextView) view.findViewById(R.id.textView1);
        tv.setText("Done!");
        return view;

    }

    public void setViewText(String text){
        tv.setText(text);
    }
}