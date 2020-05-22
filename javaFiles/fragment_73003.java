new Thread() {
public void run() {
    String id=emailIdField.getText();
    String subject=subjectField.getText();
    String body=mailBodyArea.getText();
    System.out.println(id);
    System.out.println(subject);
    System.out.println(body);
    String user= "razr005@gmail.com";
    String pass="impe(*&amit";
    String host="smtp.gmail.com";
    sendEmail= new SendEmail();
    sendEmail.sendMail( id, user, subject ,body ,host, user, pass );
}
}.start();