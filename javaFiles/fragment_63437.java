@Override
public void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_student__data);

    studentName= (EditText) findViewById(R.id.editText1);
    StuClass= (EditText) findViewById(R.id.editText2);        
    b1=(Button) findViewById(R.id.button1);                
    b1.setOnClickListener(this);
}

@Override
public void onClick(View v) 
{
    // TODO Auto-generated method stub
    NameStudent = studentName.getText().toString();
    ClassStudent = StuClass.getText().toString();        
    insertData(NameStudent, ClassStudent);
}