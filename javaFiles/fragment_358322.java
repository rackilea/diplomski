File f = new File(fileName);
if(!f.exists()){ // if the file does not exist
  // Your try-catch block here
}else{  // this means that there is a file with the given name
  System.out.println("You really want to override? y/n");
  String r = console.next();
  if(r.toLowerCase().equals("y")){
    // Your try-catch-block again
  }else{
    // Nothing here
    // to restart the loop.
  }
}