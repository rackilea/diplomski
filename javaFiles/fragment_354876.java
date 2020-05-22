public class KCalendarView extends LinearLayout {

    private YearMonthDate currentJalaliDate;

    private int parentWidth, parentHeight;

    private Button leftButton, rightButton;
    private GridView gridView;

    private KCalendarAdapter calendarAdapter;

    public KCalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);

        doInflate();
    }

    private void doInflate() {
        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        inflate(getContext(), R.layout.kcalendar_view, this);

        leftButton = (Button)findViewById(R.id.btnKCalendarNavLeft);
        rightButton = (Button)findViewById(R.id.btnKCalendarNavRight);
        gridView = (GridView)findViewById(R.id.gridViewKCalendar);

        init();
    }

    private void init() {
        Calendar c = Calendar.getInstance();
        YearMonthDate currentGregDate = new YearMonthDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE));
        currentJalaliDate = JalaliCalendar.gregorianToJalali(currentGregDate);
        calendarAdapter = new KCalendarAdapter(context, currentJalaliDate.getYear(), currentJalaliDate.getMonth());
        gridView.setAdapter(calendarAdapter);
    }

    public void nextMonth() {

    }

    public void prevMonth() {

    }
}