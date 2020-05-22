Uri uri = Uri.fromFile(new File(mFile));  
Intent intent = new Intent(Intent.ACTION_SEND); 
intent.putExtra(Intent.EXTRA_STREAM, uri);
intent.setType("image/png"); 

Intent htcIntent = new Intent("android.intent.action.SEND_MSG");
htcIntent.setType("image/png");
htcIntent.putExtra(Intent.EXTRA_STREAM, uri);

Intent chooser = Intent.createChooser(intent, "Send Method");
chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] { htcIntent });
startActivity(chooser);