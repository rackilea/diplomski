EditText Login;

 public void onCreate(Bundle savedInstanceState) 
  {     
 super.onCreate(savedInstanceState);     
 setContentView(R.layout.main);   
 // Add Click listeners for all buttons    

  Login = (EditText) findViewById(R.id.entry);     

 View firstButton = findViewById(R.id.ok);     

  firstButton.setOnClickListener(this); 
  }  

  public void onClick(View v) 
     {      
      switch(v.getId())
        {         
         case R.id.ok:

          String logDetail = Login.getText().toString();

           Intent j = new Intent(this, Webscreen.class);

j.putExtra(com.tatai.froyo.Webscreen.URL,"http://192.168.1.12/index2.php?log="+logDetail);
          startActivity(j);     
           break;     
          }