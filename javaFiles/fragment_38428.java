public class SchedulerFragment extends Fragment {

    private CalendarView calendarView;

    public SchedulerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        calendarView = view.findViewById(R.id.scheduler_calendar);
        calendarView.setOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull final CalendarView view, final int year, final int month,
                    final int dayOfMonth) {
                Toast.makeText(getActivity(), "Date changed to" + dayOfMonth + "." + month + "." + year, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_scheduler, container, false);
        return root;
    }

}