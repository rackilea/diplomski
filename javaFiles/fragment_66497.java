public void sendMail(...) throws Exception{
  try{
    // mail code here...


  } catch(NoSuchProviderException e){
    throw new Exception(e);
  }
}