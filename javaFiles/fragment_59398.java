observer = new FileObserver(pathToWatch) { // set up a file observer to watch this directory on sd card

     @Override
     public void onEvent(int event, String file) {
         //if(event == FileObserver.CREATE && !file.equals(".probe")){ // check if its a "create" and not equal to .probe because thats created every time camera is launched
         Log.d(TAG, "File created [" + pathToWatch + file + "]");

         Toast.makeText(getBaseContext(), file + " was saved!", Toast.LENGTH_LONG).show();
         //}
     }
 };
 observer.startWatching(); //START OBSERVING