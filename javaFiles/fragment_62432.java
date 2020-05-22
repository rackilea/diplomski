//when user clicks on "commentname" edittext we want a new textbox to open
    commentname.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_UP) {
          AlertDialog.Builder builder = new AlertDialog.Builder(NewContact.this);
          builder.setTitle("Ur Comment:");

          //start the following xml file/ layout
          View viewInflated = LayoutInflater.from(NewContact.this).inflate(R.layout.comment_text_pop_up, null, false);
          builder.setView(viewInflated);

          // Set up the buttons
          builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              dialog.dismiss();
            }
          });
          builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              dialog.cancel();
            }
          });

          builder.show();
          return true;

        }
        return false;

      }
    });