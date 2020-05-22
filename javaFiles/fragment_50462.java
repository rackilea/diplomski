PropertySet propertySet = new PropertySet(EmailMessageSchema.ToRecipients);
    EmailMessage email = EmailMessage.bind(service, new ItemId(emailId), propertySet);
    EmailAddressCollection toRecipients = email.getToRecipients();
    for (EmailAddress toRecipient : toRecipients) {
        String address = toRecipient.getAddress();
        // go on
    }