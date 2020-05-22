if(resource != null) {
  try{
     resource.close();
  } catch(IOException e){
     //omit
  }
}