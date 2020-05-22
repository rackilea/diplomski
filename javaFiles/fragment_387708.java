public FragmentCalendar() {
        RelativeLayout activeDay = (RelativeLayout)getActivity(). findViewById(R.id.sundayRelativeLayout);
        View viw = new View(null);
        RelativeLayout.LayoutParams lay = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,2);
        lay.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        viw.setBackgroundColor(Color.BLUE);
        viw.setLayoutParams(lay);
        activeDay.addView(viw);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calendar,
                container, false);

        return rootView;
    }