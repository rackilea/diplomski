TextView textTip,textHour,textWage;
    EditText editHour,editTip;
    float wage;
    int precision = 100;
    String sTip,sHour;
    Intent i; // declare here

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
textTip = (TextView) findViewById(R.id.tvTip);
    textHour = (TextView) findViewById(R.id.tvHour);
    textWage = (TextView) findViewById(R.id.tvWage);
    editTip = (EditText) findViewById(R.id.etTip);
    editHour = (EditText) findViewById(R.id.etHour);
    Button bSubmit = (Button) findViewById(R.id.bSubmit);
    final Bundle bTip = new Bundle();
    final Bundle bHour = new Bundle();
    final ArrayList<String> tipList = new ArrayList<String>();    
    final ArrayList<String> hourList = new ArrayList<String>();
    bSubmit.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            textHour.setText(editHour.getText().toString());
            textTip.setText(editTip.getText().toString());
            wage = Float.parseFloat(textTip.getText().toString()) / Float.parseFloat(textHour.getText().toString());
            String tip = String.format("$%.2f",wage);
            textWage.setText(String.valueOf(tip) + " an hour");     
            textHour.setText(editHour.getText() + " Hour(s)");
            textTip.setText("$" + editTip.getText());
            bTip.putStringArray(sTip,new String[] {editTip.getText().toString()});
            bHour.putStringArray(sHour,new String[] {editHour.getText().toString()});
            tipList.addAll(Arrays.asList(sTip));
            hourList.addAll(Arrays.asList(sHour));
            i = new Intent(TipBookActivity.this,History.class);
            i.putExtras(bTip);
            i.putExtras(bHour);
        }       
    });
}
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
        case R.id.menuHistory:
             startActivity(i));        // start Activity here by passing intent    
             return true;