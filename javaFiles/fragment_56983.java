Button go  = (Button) findViewById(R.id.button1); 
final String code[] = {"m1", "n2"};
final double pointx[] = {23.666666, 65.22222};
final double pointy[] = {31.55555, 29.665544};

go.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent transfercode = new Intent(getApplicationContext(), FeenbezabtActivity.class);

        // mn should be read after the button click!
        EditText coderead = (EditText) findViewById(R.id.editText1);
        final String mn = coderead.getText().toString();          

        for (int i = 0; i < code.length; i++) {
            if (code[i].equals(mn)) {
                transfercode.putExtra("lat2", pointx[i]);
                transfercode.putExtra("long", pointy[i]);
                startActivity(transfercode);
            } else {
                Toast.makeText(getBaseContext(), "code not found", 5000);
            }
        }
    }
});