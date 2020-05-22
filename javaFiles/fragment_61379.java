final Context context = this;
AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

// set title
alertDialogBuilder.setTitle("Your Title");

// set dialog message
alertDialogBuilder
    .setMessage("Click to visit website!")
    .setCancelable(false)
    .setPositiveButton("Go to web site",new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog,int id) {
            // if this button is clicked

              Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.your-web-site-url.com"));
              startActivity(browserIntent);

        }
    }));

// create alert dialog
AlertDialog alertDialog = alertDialogBuilder.create();

// show it
alertDialog.show();