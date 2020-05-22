public boolean saveOrUpdateA(A a) {
  boolean success = false;   
  try {
    // obtaining session is omitted
    session.saveOrUpdate(a);
    success = true;

  } catch (Exception e) {
    // log it and swallow exception
    // calling code has to be sure to check on success flag; 
    // otherwise it has no idea something went terribly wrong
  } 
  return success ;
}