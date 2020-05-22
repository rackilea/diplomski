public class TopfreeFragment extends Fragment implements View.OnClickListener{

    View view;
    private Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_topfree, container, false);
        btn = (Button) view.findViewById(R.id.button2);
        btn.setOnClickListener(this);
        return view;
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button2:
                 startActivity(new Intent(getActivity(),Electronicspage.class));
            break;

            case R.id.XXXXX:
            break;
            // more button......

        }
    }
}