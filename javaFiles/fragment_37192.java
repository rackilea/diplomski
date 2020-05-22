public class Tab1Fragment extends Fragment {

    ...

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_one, container, false);
        receiveQR = (ImageView) view.findViewById(R.id.receive_QR);

        ...

        // you're returning a new inflated view here which is incorrect.
        return inflater.inflate(R.layout.fragment_one, container, false);

    }
}