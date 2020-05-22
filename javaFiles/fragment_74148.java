class EnumUtils {
    String getTemplate(type) {
      "template" + type       
    }

    String getFrom(type) {        
    }

    String getTo(type) {        
    }

    String getBcc(type) {        
    }
}

enum EmailTypeAdministration {
    REMINDER_ADMIN('reminderForAdmin'),
    REMINDER_PRODUCTION('reminderForProduction')

    @Delegate EnumUtils enumUtils = new EnumUtils()
    EmailTypeAdministration(str) {} 
}

enum EmailTypeClients {
    REMINDER_MANAGEMENT('reminderForManagement'),
    REMINDER_CUSTOMER('reminderForCustomer')

    @Delegate EnumUtils enumUtils = new EnumUtils()
    EmailTypeClients(str) {}
}

EmailTypeAdministration emailTypeAdmin = EmailTypeAdministration.REMINDER_ADMIN
assert 'templateParam' == emailTypeAdmin.getTemplate('Param')