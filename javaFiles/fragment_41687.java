try (ResultSet results = retrieveMessages()) {
    while (results.next()) {
        String to = results.getString("tblEmail.to");
        String from = results.getString("tblEmail.from");
        String subject = results.getString("tblEmail.subject");
        String message = results.getString("tblEmail.message");
        MailBox.add(new Email(to, from, subject, message));
    }
}