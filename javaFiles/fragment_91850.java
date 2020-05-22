String shareBody = "Here is the share content body";
Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
sharingIntent.setType("text/plain");
sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_using)));