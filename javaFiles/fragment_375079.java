protected void onCreate(Bundle savedInstanceState) {

  super.onCreate(savedInstanceState);
  setContentView(R.layout.chat);
  chatmessage = (EditText) findViewById(R.id.entermessage);

  list = (ListView) findViewById(R.id.list);

  try { 
      /** You need the following line added to your code */
      messages = new ArrayList<Message>();
      adapter = new ChatAdapter(this, messages); //In this line the messages was not initialised in your code
      list.setAdapter(adapter); 
      addNewMessage(new Message("test msg",false)); 
      chatmessage.setText("hey");
      } catch(Exception e) {
          chatmessage.setText(e.getMessage()); 
  } 
}