final OnClickLisener listener = new OnClickListener() {
     public void onClick(View v){
         switch(v.getId()){ 
         case R.id.zero:
            break;
         case R.id.one:
            break;
         case R.id.two:
            break;
         }
     }
}
final int[] btnIds = new int[]{R.id.one, R.id.two, R.id.zero};
for(int i = 0; i < btnIds.length; i++) {
    final Button btn = (Button)findViewById(btnIds[i]);
    btn.setOnClickListener(listener);
}