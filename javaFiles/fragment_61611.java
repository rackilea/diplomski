private void sendMail() {
    //Getting content for email
    String email = editTextEmailValue.getText().toString().trim();
    String subject = editTextSubjectValue.getText().toString().trim();
    String message = editTextMessageValue.getText().toString().trim();

    //Creating SendMail object
    SendMail sm = new SendMail(this, email, subject, message);

    //Executing sendmail to send email
    sm.execute();
}