int EMAIL = 101;

Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
emailIntent.setType("text/html");

emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[]{});
emailIntent.putExtra(android.content.Intent.EXTRA_BCC,new String[]{});
emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
emailIntent.putExtra(android.content.Intent.EXTRA_STREAM, pngUri);
startActivityForResult(emailIntent,EMAIL);