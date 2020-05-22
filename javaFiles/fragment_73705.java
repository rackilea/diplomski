public class soActivity extends AppCompatActivity {
private CalendarView cView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so);
        cView = findViewById(R.id.calendarView);
        cView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(soActivity.this, "date: "+dayOfMonth, Toast.LENGTH_LONG).show();
            }
        });

    }
}