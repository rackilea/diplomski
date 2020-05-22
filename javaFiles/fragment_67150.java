observer = new FileObserver(pathToFile,MODIFY + CLOSE_WRITE)
     @Override
     public void onEvent(int event, String file) {
         Log.d(TAG, "File changed[" + pathToWatch + file + "]");
         //TODO: check file size...
     }
 };
 observer.startWatching();