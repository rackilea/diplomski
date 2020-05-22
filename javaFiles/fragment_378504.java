@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.popupvalores);

    valor1 = (EditText) findViewById (R.id.editText1);
    myEditValue = valor1.getText().toString();

    Log.debug("logtag", myEditValue); // Here you can see the output.

    try {
        valor = Integer.parseInt(myEditValue); 
    }
    catch(Exception e) {
        Log.e("logtag", "Exception: " + e.toString());
    }
}