word = (EditText)findViewById(R.id.entry); 
jumble = (TextView) findViewById(R.id.jumble);
Button btnJumble = (Button)findViewById( R.id.button );

btnJumble.setOnClickListener( new View.OnClickListener(){
    public void onClick(View v){
        jumbleMe(word.getText().toString());
}