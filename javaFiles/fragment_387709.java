public FragmentCalendar() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View v = new View(getActivity());

        v = inflater.inflate(R.layout.fragment_calendar, container, false);
        View pl = v.findViewById(R.id.thursdayHeaderRelativeLayout);
        View Paper = new View(pl.getContext());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,2);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        Paper.setLayoutParams(params);
        Paper.setBackgroundColor(getActivity().getColor(R.color.strong_blue));

        ((RelativeLayout)pl).addView(Paper);

        //Zet de datum op zondag
        //View tv = v.findViewById(R.id.sundayDateTextView);
        //((TextView)tv).setText("13");

        return v;
    }