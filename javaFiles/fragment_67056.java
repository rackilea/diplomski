public class MainDatabase extends AppCompatActivity {

    private static final String TAG = "MainDatabase";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnViewData;
    private EditText 
        editText,            
        editTextLast,        //<<<< ADDED
        editPassword,        //<<<< ADDED
        editPasswordConfirm, //<<<< ADDED
        editPhoneNumber,     //<<<< ADDED
        editEmailAddress,    //<<<< ADDED
        editAddressLine1,    //<<<< ADDED
        editAddressLine2,    //<<<< ADDED
        postcodeUser,        //<<<< ADDED
        country;             //<<<< ADDED

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        editTextLast = findViewById(R.id.editTextLast); //<<<< CHANGED
        editPassword = findViewById(R.id.editPassword); //<<<< CHANGED
        editPasswordConfirm = findViewById(R.id.editPasswordConfirm); //<<<< CHANGED
        editPhoneNumber = findViewById(R.id.editPhoneNumber); //<<<< CHANGED
        editEmailAddress = findViewById(R.id.editEmailAddress); //<<<< CHANGED
        editAddressLine1 = findViewById(R.id.editAddressLine1); //<<<<CHANGED
        editAddressLine2 = findViewById(R.id.editAddressLine2); //<<<< CHANGEDX
        postcodeUser = findViewById(R.id.postcodeUser); //<<<< CHANGED
        country = findViewById(R.id.county); //<<<< CHANGED
        btnAdd = findViewById(R.id.btnAdd);
        btnViewData = findViewById(R.id.btnView);
        mDatabaseHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                String newName = editTextLast.getText().toString(); //<<<< CHANGED
                Integer newPass = Integer.parseInt(editPassword.getText().toString()); //<<<< CHANGED
                String newPhone = editPhoneNumber.getText().toString(); //<<<< CHANGED
                String newEmail = editEmailAddress.getText().toString(); //<<<< CHANGED
                String newAdd1 = editAddressLine1.getText().toString(); //<<<< CHANGED
                String newAdd2 = editAddressLine2.getText().toString(); //<<<< CHANGED
                String newPC = postcodeUser.getText().toString(); //<<<< CHANGED
                String newCounty = country.getText().toString(); //<<<< CHANGED

                if (editText.length() != 0) {
                    AddData(newEntry, newName, newPass, newPhone, newEmail, newAdd1, newAdd2, newPC, newCounty);


                    editText.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }

            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDatabase.this, ListDataActivity.class);
                startActivity(intent);
            }
        });

    }



    public void AddData(String newEntry, String newName, Integer newPass, String newPhone, String newEmail, String newAdd1, String newAdd2, String newPC, String newCounty) {
        boolean insertData = mDatabaseHelper.addData(newEntry,newName,newPass,newPhone,newEmail,newAdd1,newAdd2,newPC,newCounty);


        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}