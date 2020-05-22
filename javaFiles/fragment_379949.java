try{
   ... do loads of stuff
   return value;
} catch(Exception e) {
    e.printStackTrace(); //log it, whatever
    return null;
}