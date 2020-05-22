class MyClass extends Activity{

  public onCreate(Bundle savedInstanceState){
    Button btn = new Button();
    btn.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View arg0) {
           DataManager dm=new DataManager(MyClass.this);

        }
    });

  }
}