public class ChildFragment extends Fragment {
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.activity_main, container, false);
    String item = "<p>ABCDEFGHI</p><br><p>JKLMNOPQRSTUVWXYZ</p>";
    TextView textview = (TextView) rootView.findViewById(R.id.textView2);
    textview.setText(Html.fromHtml(item));

    return rootView;
}