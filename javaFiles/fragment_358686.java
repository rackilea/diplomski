MediaPlayer mp = new MediaPlayer();
AssetFileDescriptor bearAfd = getResources().openRawResourceFd(R.raw.bear_hurt);
AssetFileDescriptor screamAfd = getResources().openRawResourceFd(R.raw.splashscream);

mp.setDataSource(bearAfd.getFileDescriptor(), bearAfd.getStartOffset(), bearAfd.getLength();
mp.prepare();
mp.start();

//then to set it to another one
mp.setDataSource(screamAfd.getFileDescriptor(), screamAfd.getStartOffset(), screamAfd.getLength();
mp.prepare();
mp.start();