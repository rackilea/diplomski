public class MainActivity extends AppCompatActivity {
    RecyclerView mClassListRV;
    ClassRVAdapter mCRVAdapter;
    LinearLayoutManager mLLM;
    DBHelper mDBH;
    List<ClassesBean> mClassList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mClassListRV = (RecyclerView) this.findViewById(R.id.classlist);
        mDBH = new DBHelper(this); // Ready to use DBHelper

        addSomeData(); //<<<< Add some data for testing

        mClassList = mDBH.getClasses(); // Get the list of classes from the DB

        mLLM = new LinearLayoutManager(this); 
        mClassListRV.setHasFixedSize(true);
        mClassListRV.setLayoutManager(mLLM);
        mCRVAdapter = new ClassRVAdapter(this,mClassList);
        mClassListRV.setAdapter(mCRVAdapter);
    }

    public void removeAt(int position, long id) {
        mDBH.deleteAClass(id);

        mClassList.remove(position);
        mClassListRV.removeViewAt(position);
        mCRVAdapter.notifyItemRemoved(position);
        mCRVAdapter.notifyDataSetChanged();
    }


    private void addSomeData() {
        if (DatabaseUtils.queryNumEntries(mDBH.getWritableDatabase(),DBHelper.TB_CLASSES) < 1) {
            mDBH.insertClass(10, "English", "E101", "XYZ", "Fred Smith, Bert Bloggs", "JANET, JOHN");
            mDBH.insertClass(11, "English Literature", "E201", "ZXY", "Tom Brown, Bill Rigidspear", "JOHN, MARY");
            mDBH.insertClass(22, "Chemistry", "C045", "H2O", "Bert Steinein", "SUSAN, JOE");
        }
    }
}