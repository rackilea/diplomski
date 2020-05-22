class EmailService {
  void sendVerificationEmail(Email userEmail) {
    email.setToAddress(userEmail.getEmailId());
    email.setContent("Hey User, this is your OTP + Random.newRandom(100000));
    email.send();
}