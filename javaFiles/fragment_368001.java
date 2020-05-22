if (null != recorder) {
   try{     
      recorder.stop();
   }catch(RuntimeException ex){
   //Ignore
   }
   ...
}