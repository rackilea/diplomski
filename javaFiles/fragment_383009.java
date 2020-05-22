while(response.read()){
  //do stuff here
int progress = getProgress(); //set the progress to something
  a.runOnUiThread(new Runnable(){
    a.updateProgress(progress);
  });
}