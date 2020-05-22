public class MainActivity extends AppCompatActivity {

    DBHelper mDB;
    String[] checkdates = new String[]{"2018-09-10","2018-09-11","2018-09-09"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDB = new DBHelper(this);

        mDB.addNewDayEntry("2018-09-10");
        mDB.setDayEntryForOneCheckBox("2018-09-10",1);
        mDB.setDayEntryForOneCheckBox("2018-09-10",3);
        mDB.setDayEntryForOneCheckBox("2018-09-10",8);
        mDB.setDayEntryForOneCheckBox("2010-09-09",7); //<<<<<<<<<< wont set as DAY ENTRY NOT ADDED

        StringBuilder sb = new StringBuilder("");
        for (String s: checkdates) {
            sb.append("\nChecking Date ").append(s);
            for(int i=1; i <= 10; i++) {
                sb.append("\n\tCHECKBOX ").append(String.valueOf(i)).append(" IS ").append(String.valueOf(mDB.isDayEntryCheckboxSet(s,i)));
            }
        }
        Log.d("CHECKBOX STATES",sb.toString());
    }
}