private void sendActionPerformed(java.awt.event.ActionEvent evt) {  
  //implement code to show progress label here
  SMSWorker w = new SMSWorker(user, pass, senderIdString, msgString, msisdn.split(","));
  w.execute();
}

public SMSWorker extends SwingWorker<Void, DeliveryReport> {

  private final String user;
  private final String pass;
  private final String senderIdString;
  private final String msgString;
  private final String[] arMSISDN;

  // this constructor runs on the current (EDT) thread.
  public SMSWorker(String user, String pass, String senderIdString, String msgString, String[] arMSISDN) {
    this.user = user;
    this.pass = pass;
    this.senderIdString = senderIdString;
    this.msgString = msgString;
    this.arMSISDN = arMSISDN;
  }

  // this function runs in a separate thread.
  public Boolean doInBackground() {

       // Instantiate SMS gateway client.
       SendSMS sms = new SendSMS();

       // Assuming a delivery report can be created like this.
       DeliveryReport deliveryReport = new DeliveryReport();

       for (int i = 0; i < arMSISDN.length; i++) {

            fone = arMSISDN[i];
            fone = fone.trim();
            try {
                sms.sendSMS(user, pass, fone, senderIDString, msgString);

            } catch (Exception e) {
                // you can notify users about exception using the publish() method.

            } finally {
                deliveryReport.append(fone + ": " + sms.response + "\n");
            }

        }

        return deliveryReport;

  }

  // this function runs on the current (EDT) thread.
  public void done() {
    try {
      // synchronize worker thread with EDT.
      DeliveryReport deliveryReport = get();
    } catch (Exception e) {
      //implement code to notify user about errors here.
    } finally {
      //implement code to hide progress label here.
    }
}