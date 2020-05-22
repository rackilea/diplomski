public class ConnectFragment extends Fragment {

final Button ClassAButton;
TextView FeloniesText;



public ConnectFragment() {
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_connect, container, false);
    init(rootView);
    return rootView;

}


public void init(View view)
{
    ClassAButton = (Button) view.findViewById(R.id.ClassAButton);
    FeloniesText = (TextView) view.findViewById(R.id.FeloniesText);
    ClassAButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    FeloniesText.setText("Button 1 Has been pressed!");
                }
            }
    );
}