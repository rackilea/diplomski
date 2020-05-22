String title=noteModel.getTitle();
String content=noteModel.getContent();
String titleAndContent="Title: "+title+"\n Content: "+content;

Intent intentShare = new Intent();
intentShare.setAction(Intent.ACTION_SEND);
intentShare.setType("text/plain");
intentShare.putExtra(Intent.EXTRA_TEXT,titleAndContent);

context.startActivity(intentShare);