public class register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnsignup;
    Spinner spinner; //<<<<<<<<<< DECLARED HERE
    ArrayAdapter<CharSequence> adapter; //<<<<<<<<<< DECLARED HERE
    EditText _txtFname, _txtLname, _txtpass, _txtemail, _txtrollno, _txtbranch /* <<<<<<<<<< CHANGED  to add _txtbranch>>>>>>>> */;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        openHelper=new DatabaseHelper(this);

        _btnsignup= findViewById(R.id.btn_signup);
        _txtFname=findViewById(R.id.fname);
        _txtLname=findViewById(R.id.lname);
        _txtpass=findViewById(R.id.password);
        _txtemail=findViewById(R.id.email);
        _txtrollno=findViewById(R.id.rollno);
        _txtbranch=findViewById(R.id.branch); /* <<<<<<<<<< ADDED >>>>>>>>>> Alternately not needed if getting item directly from spinner*/
        spinner=findViewById(R.id.semester); /*<<<<<<<<<<< MOVED TO HERE spinner defined as a class variable */

        _btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper.getWritableDatabase();
                String fname=_txtFname.getText().toString();
                String Lname= _txtLname.getText().toString();
                String pwd= _txtpass.getText().toString();
                String email= _txtemail.getText().toString();
                String rollno= _txtrollno.getText().toString();
                String branch = _txtbranch.getText().toString(); // code wanted BUT not needed if value obtained directly from the spinner
                //String branch = spinner.getSelectedItem().toString(); // ALTERNATIVE no need  _txtbranch duplicating selected value

                insertdata(Fname, Lname, pwd,email,rollno);
                Toast.makeText(getApplicationContext(), "Registered Succesfully", Toast.LENGTH_LONG).show();
                //Toast.makeText(view.getContext(),"Registered Succesfully", Toast.LENGTH_LONG).show(); // Alternative to previous line gets the context from the view
            }
        });

        adapter = ArrayAdapter.createFromResource(this, R.array.semester,android.R.layout.simple_spinner_item); //<<<<<<<<<< CHANGED
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this); //<<<<<<<<<< not really needed as selected item can be retrieved directly from spinner
    }

    public void insertdata( String Fname, String Lname, String pwd, String email, String rollno) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, Fname);
        contentValues.put(DatabaseHelper.COL_3, Lname);
        contentValues.put(DatabaseHelper.COL_4, pwd);
        contentValues.put(DatabaseHelper.COL_5, email);
        contentValues.put(DatabaseHelper.COL_6, rollno);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }

    // Not needed if retrieving value directly from spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String text=adapterView.getItemAtPosition(i).toString();
        //branch= (EditText)findViewById(R.id.branch);
        String text2=adapterView.getSelectedItem().toString();
        _txtbranch.setText(text2);
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT).show();

    }

    // Not needed if retrieving value directly from spinner
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void open_login(View view){
        startActivity(new Intent(getApplicationContext(),login.class));
    }
}