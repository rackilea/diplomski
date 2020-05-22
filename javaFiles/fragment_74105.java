public class DFragment extends DialogFragment {
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.dialogfragment, container,
            false);
    getDialog().setTitle("DialogFragment Tutorial");        
    // Do something else
    return rootView;
}
 }