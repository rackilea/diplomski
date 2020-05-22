public void onClick_Start(View v){
 //start of the next Inten
   Intent intent = new Intent(this, CalledActivity.class)
   intent.putExta("key",getTag()) ;
   startActivity(intent );
}