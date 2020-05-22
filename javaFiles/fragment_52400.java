String subject = "Subject text goes here.";
String body = "Body text goes here"
Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
emailIntent.setType("plain/text"); 
emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);     
emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);  
startActivity(Intent.createChooser(email, "Send Mail..."));