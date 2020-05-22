final MediaPlayer mediaPlayer=new MediaPlayer();  
final AssetFileDescriptor assetFileDescritor=pContext.getAssets().openFd(MusicFactory.sAssetBasePath
                    + pAssetPath); mediaPlayer.setDataSource(assetFileDescritor.getFileDescriptor(),assetFileDescritor.getStartOffset(),assetFileDescritor.getLength()); 
mediaPlayer.prepare();
final Music music=new Music(pMusicManager,mediaPlayer);
pMusicManager.add(music);
return music;