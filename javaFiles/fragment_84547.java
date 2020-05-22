public class MainActivity extends AppCompatActivity implements OnDateSetListener, OnTimeSetListener {

    // Your code her
    ...

    @Override
    public void onDateSet(String tag, DatePicker view, int year, int month, int dayOfMonth) {
        // Process code with tag here
    }

    @Override
    public void onTimeSet(String tag, TimePicker view, int hourOfDay, int minute) {
        // Process code with tag here.
    }
}