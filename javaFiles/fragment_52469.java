@Override
public boolean onCreateOptionsMenu(Menu menu){
    //Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.first, menu);
    return true;
}

private void addButtonListener() {
    // TODO Auto-generated method stub

    //finding your image button
    ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton2);

    btn1.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {

           Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);  
           startActivityForResult(intent, 1); 

        } // `);` moved from here to the line below
    });
} // This little thingy was waaaaaay too far down. This is the end for one method

@Override
public boolean onCreateOptionsMenu(Menu menu){ // So here another method can start
    //Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.first, menu);
    return true;
}