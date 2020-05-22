@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) 
{
        View view = inflater.inflate(R.layout.fragment_profilo, null);
        LinearLayout root_view = (LinearLayout) view .findViewById(R.id.linear_layout_main_profilo);
        TextView word_view_1 = new TextView(getActivity());
        word_view_1.setText(namesOfNumbers.get(0));
        root_view.addView(word_view_1);

        return view;
}