public class TabFragment1 extends Fragment {
private TextView tv;

public static TabFragment1 create(String text){
   Bundle b = new Bundle();
   b.putString("textdata",text);
   TabFragment1  f = new TabFragment1();
   f.setArguments(b);
   return f;
}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.tab_fragment_1, container, false);
    tv = (TextView) view.findViewById(R.id.textView);
    if(getArguments()!=null){
      tv.setText(getArguments().getString("textdata"));
    }

    return view;
}

    public void setText(String text){
    tv.setText(text);
}

}