DownloadEvent event = getDownloadEvent(); //returns a download event

switch(event.getType() ){
case DownloadEvent.DOWNLOAD_STARTED.getType():
    //do some stuff
}