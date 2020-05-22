int rando = (int) (Math.random() *5);
String text = gn[rando];

Intent sendIntent = new Intent(Intent.ACTION_SEND);
sendIntent.putExtra(Intent.EXTRA_TEXT, text);
sendIntent.setType("text/plain");
startActivity(sendIntent);