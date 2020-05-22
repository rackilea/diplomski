public void regPageTwo()
 {
    setContentView(R.layout.layout_register_two);
    new dataExchange().execute(1);
    Log.i("Data", dbData);
 }