class UserAuthUsernamePassword extends UserAuthPassword {

  public boolean start(Session session) throws Exception {
    this.username = "real_username";
    return super.start(session);
  }

}