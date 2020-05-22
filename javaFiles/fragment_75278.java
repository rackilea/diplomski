Intent intent = new Intent(Third.this, Fourth.class);
intent.putExtra("thetext", et.getText().toString());
x=Double.parseDouble(et.getText().toString());
val1=(x*.04);
intent.putExtra("thevalue1",val1);
startActivity(intent);