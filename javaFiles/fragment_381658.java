Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
sharingIntent.setType("text/plain");
String shareBody = "Here is the share content body";
sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
startActivity(Intent.createChooser(sharingIntent, "Share via"));