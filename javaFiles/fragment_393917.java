@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);
   btn=(Button)findViewById(R.id.button);
   button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mTcpClient.senMessage("get Text from text box");
      }
   });

edt=(EditText)findViewById(R.id.editText);
ConnectTask connectTask=new ConnectTask();
connectTask.execute("testing");