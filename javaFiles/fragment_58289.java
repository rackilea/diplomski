public class MainActivity extends AppCompatActivity {

    DBHelper mDBHlpr;
    ArrayList<Long> terms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDBHlpr = new DBHelper(this);
        addSometestingData();
        Cursor csr = mDBHlpr.getAllCoursesWithTermDetails();
        DatabaseUtils.dumpCursor(csr);
        csr = mDBHlpr.getAllAssessmentsWithCourseAndTermdetails();
        DatabaseUtils.dumpCursor(csr);
    }

    private void addSometestingData() {
        if (DatabaseUtils.queryNumEntries(mDBHlpr.getWritableDatabase(), TermDbSchema.TermTable.NAME) < 1) {
            addSomeTerms();
            addSomeCourses();
            addSomeAssessments();
        }
    }

    private void addSomeTerms() {
        terms.add(mDBHlpr.addTerm("TERM001","2019-01-01","2019-0331"));
        terms.add(mDBHlpr.addTerm("TERM002","2019-04-01","2019-06-30"));
        terms.add(mDBHlpr.addTerm("TERM003","2019-07-01","2019-09-30"));
        terms.add(mDBHlpr.addTerm("TERM004","2019-10-01","2019-12-31"));
    }

    private void addSomeCourses() {
        mDBHlpr.addCourse(
                "Math01",
                "2019-01-01","2019-03-14","2019-01-03","2019-03-07",
                "OK","blah",
                "Fred","0000000000","fred@email.com",
                terms.get(0));
        mDBHlpr.addCourse(
                "Math02",
                "2019-04-01","2019-06-14","2019-04-03","2019-06-07",
                "OK","blah",
                "Fred","0000000000","fred@email.com",
                terms.get(1));
        mDBHlpr.addCourse(
                "Math03",
                "2019-07-01","2019-09-14","2019-07-03","2019-09-07",
                "OK","blah",
                "Fred","0000000000","fred@email.com",
                terms.get(2));
        mDBHlpr.addCourse(
                "Math01",
                "2019-10-01","2019-12-14","2019-10-03","2019-12-07",
                "OK","blah",
                "Fred","0000000000","fred@email.com",
                terms.get(3));
    }

    private void  addSomeAssessments() {
        mDBHlpr.addAssessment("MATH02-A01","?","2019-01-31","2019-01-24",1);
        mDBHlpr.addAssessment("MATH01-A02","?","2019-02-28","2019-02-21",1);
        mDBHlpr.addAssessment("MATH01-A03","?","2019-03-31","2019-03-24",1);
        mDBHlpr.addAssessment("MATH02-A01","?","2019-04-30","2019-04-23",2);
        // and so on
    }
}