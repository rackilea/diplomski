Intent intent = getIntent();
String level = intent.getStringExtra(Game.KEY_LEVEL);

File myFile;
if (Game.KEY.equals(getResources().getText(R.string.easy_label))) {
   myFile = new File(insert here the path of the file that contains the easy questions);
} else if (Game.KEY.equals(getResources().getText(R.string.medium_label))) {
   myFile = new File(insert here the path of the file that contains the medium questions);
} else {
   myFile = new File(insert here the path of the file that contains the hard questions);
}