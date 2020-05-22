tv2.setOnClickListener(new OnClickListener() {

public void onClick(View v) {
    Intent intent = new Intent(Contact.this,Discution.class);

            String str = tv2.getText().toString(); 

            startActivity(intent);
}