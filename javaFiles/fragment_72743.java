public YourClass {

    private    ExecutorService executorService = Executors.newFixedThreadPool(10);

   public void yourMethod() {
     if (operation.equals("Insert")) {
       String SQLInsertMgmtUser = "INSERT INTO User (depotID , emp_ID , appUserName)VALUES(? , ? , ?)";
       executorService.execute(new Runnable() {
         public void run() {
            SendEmailUtility.sendmail(empmail, generatedPwd_str);
         }
      });
   } 
}