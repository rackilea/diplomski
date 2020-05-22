public void saveOrUpdateA(A a) throws Exception {

  try {
    // obtaining session is omitted
    session.saveOrUpdate(a);
  } catch (Exception e) {
    // log it and rethrow; let calling code figure how to handle
    throw e;
  } 
}