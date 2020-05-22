public void saveProcess (Process p) {
  ArrayList<String> name = p.getProcessesName();  // or you can get iterator from the arraylist
  String emailSent = p.getEmailSent();
  Date lastModification = p.getLastModification();
  Boolean status = p.getStatus();

  //
  // use SQL insert statements to save info
  //

}