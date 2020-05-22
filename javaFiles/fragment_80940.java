private Integer getnumber(){
  Integer i = null;
  try {
    i = new Integer(5);
  }
  catch(Exception e){
    i = new Integer(0);
  }
  finally{
    i = new Integer(7);
  }
  return i;
}