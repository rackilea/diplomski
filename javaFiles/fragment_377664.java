/**
 * Method to decide which detail view should be called on the basis of
 * notification when notification is clicked.
 * @param intent
 */
public void onNewIntent(Intent intent) {

    try {
        Bundle extras = intent.getExtras();
        if (extras != null) {
             title = intent.getStringExtra("Name");
             text = intent.getStringExtra("Description");
             noti = intent.getStringExtra("NotifyCount");

    // Locate the TextView
    txttitle = (TextView) findViewById(R.id.title);
    txttext = (TextView) findViewById(R.id.text);

    txttitle.setText("Title : "+title);
    txttext.setText(Html.fromHtml("<b> Description :</b>"+" "+text) );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}