List<NameValuePair>nameValuePairs = new ArraList<NameValuePair>(2);
AlertDialog alertName;
DefaultHttpClient client = new DefaultHttpClient();
ResponseHandler<String> responseHandler = new BasicResponseHandler();
String response = "";

HighScore(Context context, int score){
    nameValuePairs.add(new BasicNameValuePair("score", + score.toString()));
    alertName = new AlertDialog(context).create();
    EditText input = new EditText(context);
    alertName.setTitle('Enter Your Name');
    alertName.setButton(AlertDialog.BUTTON_POSITIVE, "OK", 
        new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                nameValuePairs.add(
                new BasicNameValuePair("name", input.getText().toString())
                );
                SubmitAsync sa = new SubmitAsync();
                sa.execute();
            }
    });
    alertName.show();
}