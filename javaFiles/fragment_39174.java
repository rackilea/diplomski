MediaPlayer mp = GlobalVars.getMediaPlayer();

//note that in my case, item is an object of mine that 
//contains an AssetFileDescriptor, which you can get by
//calling getAssets().openFd("filename.mp3");
AssetFileDescriptor afd = item.getDescriptor();

mp.reset();
//leaving out the try/catch block for conciseness
mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
mp.prepare();
mp.start();