public void sendSMS(User user) {
    try {

        Twilio.init(ACCOUNT_SID, AUTH_ID);

        Message.creator(new PhoneNumber(user.getPhoneNumber()), new PhoneNumber("+12029151841"),
                "Your account has been created succesfuly.").create();

    }
    catch (TwilioException e) {
        System.out.println("An error occured from twillio."+e.getMessage());
    }
}

@PostMapping(value="/registerUser")
public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelAndView modelAndView){

//skipped other is statements for checking possible errors.
else{
        //set a user to disabled by default before activation thru email.
        user.setEnabled(false);

        //save a user in the database.
        userService.save(user);

        //generating the confirmation token

        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenRepository.save(confirmationToken);

        //sending the email message

        SimpleMailMessage simpleMailMessage =   new     SimpleMailMessage();
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setSubject("Complete your registrations");
        simpleMailMessage.setFrom("devkibuchi2018@gmail.com");
        simpleMailMessage.setText("To activate your account, please     click here : "
        +"http://localhost:8080/activate-    account?token="+confirmationToken.getConfirmationToken());

        emailSenderService.sendEmail(simpleMailMessage);
        modelAndView.addObject("Email ", user.getEmail());

        //send also an sms message using Twilio.
        sendSMS(user);

        modelAndView.setViewName("successfulRegistration");

    }

    return modelAndView;
}