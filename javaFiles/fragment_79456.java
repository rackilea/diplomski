try{
  File f = new File ("001.mp3");  
  MP3Player mp3 = new MP3Player(f);
  mp3.play();
  while(!mp3.isStopped()){
    Thread.sleep(5000);
  }
}
catch(Exception e){
System.err.println(e);
}