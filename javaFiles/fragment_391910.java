String mp3path = "Your MP3 file path";   
MediaScannerConnection msc = new MediaScannerConnection(yourcontext,
        new MediaScannerConnection.MediaScannerConnectionClient() {
            @Override
            public void onScanCompleted(String path, Uri uri){
                msc.disconnect();
            }
            @Override
            public void onMediaScannerConnected() {
                msc.scanFile(mp3path, null);
            }           
        });             
msc.connect();