User user = new User();
user.setPhoneNumber("+12541254122");
        Twilio.init(ACCOUNT_SID, AUTH_ID);

        Message.creator(new PhoneNumber(user.getPhoneNumber()), new PhoneNumber("+12029151841"),
                "Your account has been created succesfuly.").create();