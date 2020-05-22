public class StudentsFormUpdate extends Activity
{
String FirstName, LastName, EmailAddress, ContactNumber, StudentID;
SQLiteDatabase db;
TextView StudentIDViewUpdate2;
EditText FirstNameUpdate2, LastNameUpdate2, ContactNumberUpdate2, EmailUpdate2;

protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.students_updateform);
    db = openOrCreateDatabase("ClassManager", MODE_WORLD_READABLE, null);

    String reciever = getIntent().getStringExtra("sender");

    Cursor c = db.rawQuery("SELECT * FROM MasterStudents WHERE StudentID = '" + reciever + "'", null);

    StudentIDViewUpdate2 = (TextView)findViewById(R.id.StudentIDViewPermanentUpdate);
    FirstNameUpdate2 = (EditText)findViewById(R.id.FirstNameTextUpdate);
    LastNameUpdate2 = (EditText)findViewById(R.id.LastNameTextUpdate);
    ContactNumberUpdate2 = (EditText)findViewById(R.id.ContactNumberTextUpdate);
    EmailUpdate2 = (EditText)findViewById(R.id.EmailAddressTextUpdate);


    c.moveToFirst();
    StudentIDViewUpdate2.setText(c.getString(c.getColumnIndex("StudentID")));
    FirstNameUpdate2.setText(c.getString(c.getColumnIndex("FirstName")));
    LastNameUpdate2.setText(c.getString(c.getColumnIndex("LastName")));
    ContactNumberUpdate2.setText(c.getString(c.getColumnIndex("ContactNumber")));
    EmailUpdate2.setText(c.getString(c.getColumnIndex("EmailAddress")));


}

public void UpdateButton(View view)
{

    StudentID = StudentIDViewUpdate2.getText().toString();
    FirstName = FirstNameUpdate2.getText().toString();
    LastName = LastNameUpdate2.getText().toString();
    ContactNumber = ContactNumberUpdate2.getText().toString();
    EmailAddress = EmailUpdate2.getText().toString();

    db.execSQL("UPDATE MasterStudents SET FirstName = '" + FirstName + "', LastName = '" + LastName + "', ContactNumber = '" + ContactNumber + "', " +
               "EmailAddress = '" + EmailAddress + "' WHERE StudentID = " + StudentID + ";");

    Toast toast = Toast.makeText(getApplicationContext(), "Student Updated", Toast.LENGTH_SHORT);
    toast.show();
    finish();
}

}