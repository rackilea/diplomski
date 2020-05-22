FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    if (fab != null)
    fab.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
                 Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 .setAction("Action", null).show();
           }
     });