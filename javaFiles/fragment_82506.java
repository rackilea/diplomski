TextView textview;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.activity_main, container, false);
    textview = (TextView) rootView.findViewById(R.id.textView2);    
    String item = "<p>ABCDEFGHI</p><br><p>JKLMNOPQRSTUVWXYZ</p>";  
    setText(item);
    return rootView;
}
public void setText(String item) {                   
    textview.setText(Html.fromHtml(item));    
}