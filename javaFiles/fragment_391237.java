super.onCreate(savedInstanceState);
if(conditions_is_true){
    Intent intent = new Intent(this,MainActivity.class);
    startActivity(intent);
    finish();
}else{
    setContentView(R.layout.tab2);
}