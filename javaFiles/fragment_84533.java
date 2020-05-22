Intent intent = new Intent(A.this, B.class);
String input1 = txt1.getText().toString();
String input2 = txt2.getText().toString();
intent.putExtra("key1", input1 );
intent.putExtra("key2", input2 );
startActivity(intent);