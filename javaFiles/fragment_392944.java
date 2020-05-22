public class MainActivity extends AppCompatActivity {

    DBHelper mDBHlpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDBHlpr = new DBHelper(this);

        long user1 = mDBHlpr.insertUser("Fred");
        long user2 = mDBHlpr.insertUser("Mary");
        Notes n1 = new Notes(-1,"My First Note",-1);
        Notes n2 = new Notes(-1,"My Second Note",-1);

        if (mDBHlpr.getNotesCount() < 1) {
            mDBHlpr.insertNote(n1.getNote(), user1);
            mDBHlpr.insertNote(n1.getNote(), user2);
            mDBHlpr.insertNote(n2.getNote(), user1);
            mDBHlpr.insertNote(n2.getNote(), user2);
        }
        List<Notes> allusers = mDBHlpr.getAllNotes();
        List<Notes> fredsnotes = mDBHlpr.getNotesByUser(user1);
        List<Notes> marysnotes = mDBHlpr.getNotesByUser(user2);
        for (Notes n: allusers) {
            logNote("ALL",n);
        }
        for (Notes n: fredsnotes) {
            logNote("FRED",n);
        }
        for (Notes n: marysnotes) {
            logNote("MARY",n);
        }
    }

    private void logNote(String type, Notes n) {
        Log.d("LOGNOTE" + type,"Note is" + n.getNote() + "\n\t ID is " + String.valueOf(n.getId()) + "\n\t" + "Owned by User who's ID is " + String.valueOf(n.getUsermap()));
    }
}