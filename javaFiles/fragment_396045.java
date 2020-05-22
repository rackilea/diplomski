Intent intent = new Intent(D,A.class);
intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
intent.putExtra("close",true);
startActivity(intent);

and in oncreat of A activity u have to write
if (getIntent().getBooleanExtra("close", false)) {finish();
}
else {
{
 //ur previous code here
}