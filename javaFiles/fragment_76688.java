MediaPlayer player = new MediaPlayer();
String path = "android.resource://"+packagename+"/raw"+filename;
try {
     player.setDataSource(context, Uri.parse(path));
     player.prepare();
     player.start();
} catch (IOException e) {
     e.printStackTrace();
}