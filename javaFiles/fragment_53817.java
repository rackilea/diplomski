@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
            ...
    case android.R.id.home:
    Intent intent = new Intent(secondActivity.this,
                        MainActivity.class);
      startActivity(intent);
      ....

    return true;
}