class EmailAuthentication implements IAuthentication {
  EmailService emailService;
  IUserProvider userProvider;

// Constructor
  public EmailAuthentication (IUserProvider userProvider, 
      EmailService emailService) {
    this.userProvider = userProvider;
    this.emailService = emailService;
  }

  public void logIn(string userName) {
    Email userEmail = this.userProvider.getUserEmail(userName);
    this.emailService.sendVerificationEmail(userEmail);
  }

  public void logOut(User user) {
    // logout
  }

  public void registerUser(UserRegistrationRequest registrationData) {
    this.userProvider.createNewUser(registrationData.getUserName, registrationData.getEmail());

    this.emailService.sendVerificationEmail(registrationData.getEmail());    
  }
}