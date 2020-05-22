public void sendMail() {
    FacesMessage message;
    try {
        Mailer.send(from, to, subject, message);
        message = new FacesMessage("Mail successfully sent!");
    } catch (MailException e) {
        message = new FacesMessage("Sending mail failed!");
        logger.error("Sending mail failed!", e); // Yes, you need to know about it as well! ;)
    }
    FacesContext.getCurrentInstance().addMessage(null, message);
}