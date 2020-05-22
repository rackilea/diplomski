Connection con;
TextView textView;    

public void onCreate(){
...
   textView = (TextView) findViewById(R.id.textView2);
   con = new Connection(context, new Connection.ConnectionListener(){

   @Override
   public void onGotXML(XMl xml){
      if(xml != null){
         textView.setText(xml.getDate());
      }else{
          Toast.makeText(getApplicationContext(),
                "no connection", Toast.LENGTH_LONG).show();
      }
     }
   });

   button.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
         con.connect();
      }

    });

}