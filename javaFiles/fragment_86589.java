...
BufferedInputStream bis = new BufferedInputStream(is);
TeeInputStream tis = new TeeInputStream(bis,new FileOutputStream("test.mp3"));

BasicPlayer player = new BasicPlayer();
player.open(tis);
player.play();