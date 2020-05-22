public class ServerFragment extends Fragment { 

    Callback iCallback;
    ...
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            iCallback = (Callback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.server_layout, container, false);

        btnServer = (Button) view.findViewById(R.id.buttonServer);   
        btnServer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                iCallback.doSomething();
            }
        });
    }
}