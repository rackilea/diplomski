buttonSubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             String title = (String) textViewTitle.getText();
             String uriStr = (String) textViewUri.getText();

             String shareString = title + ", " + uriStr;

             Intent sendIntent = new Intent();
             sendIntent.setAction(Intent.ACTION_SEND);
             sendIntent.putExtra(Intent.EXTRA_TEXT, shareString);
             sendIntent.setType("text/plain");
             startActivity(sendIntent);

        }
    });