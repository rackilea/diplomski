public class MainActivity extends AppCompatActivity {

    AnimalDBhelper mADBHlpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Create two animals
        mADBHlpr = new AnimalDBhelper(this);
        Animal myanimal1 = new Animal(1,0,"Yes","Raining");
        Animal myanimal2 = new Animal(1,0,"No","");

        mADBHlpr.addData(myanimal1); // Add the first animal
        Cursor csr = mADBHlpr.getData(); get the data
        DatabaseUtils.dumpCursor(csr); dump the data (write it to the log)
        mADBHlpr.addData(myanimal2); // Add the 2nd
        csr = mADBHlpr.getData();
        DatabaseUtils.dumpCursor(csr);
        csr.close(); // Done with the cursor so close
    }
}