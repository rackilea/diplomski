@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.fragment_main);

  final EditText numbers =  (EditText) findViewById(R.id.editText1);

  Button btnConvert = (Button) findViewById(R.id.button1);     
  btnConvert.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View arg0) {
       String numberz =numbers.getText().toString();
       try {
           final long number = Long.parseLong(numberz);
           String returnz = Words.convert(number); 
       } catch ( NumberFormatException e) {
           //Toast.makeToast("illegal number or empty number" , toast.long)
       }


    } 
     });
    }
  }