@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_schedule, container, false);
    compactCalendar = (CompactCalendarView) v.findViewById(R.id.compactcalendar_view); 
   //Make sure that the view inflated above has these view elements which you are trying to initialize
    .
    .
    .
    }