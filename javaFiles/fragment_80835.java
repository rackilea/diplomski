public class Top_Fragment extends Fragment {
    textEntered mCallback;
    Button b;
    EditText ed;

    public interface textEntered {
        public void setValue(String editextvalue);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View view = inflater.inflate(R.layout.my_fragment1, container, false);
        ed = (EditText) view.findViewById(R.id.editText1);


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        b = (Button) getView().findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String s = ed.getText().toString();
                mCallback.setValue(s);
            }

        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (textEntered) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                " must implement textEntered");
        }
    }
}