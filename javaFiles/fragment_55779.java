@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.gtacheats, menu);


    ImageView Image1 = (ImageView) findViewById(R.id.Image1);
    Image1.setClickable(true);
    Image1.setOnClickListener(new View.OnClickListener() {

        public void onClick(View V) {

        Intent intent = new Intent(V.getContext(), Activity2.class);
        startActivityForResult(intent, 0);
        }
  });
  return true;
}