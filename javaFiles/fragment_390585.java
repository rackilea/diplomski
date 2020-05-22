@Inject
private LinkSource linkSource;

@OnEvent(...)
void sendActivationEmail() {
    final Link activationLink = this.createUserActivationLink(email, otherStuff);
    this.activationEmailSender.sendWithActivationLink(email, activationLink);
}

private Link createUserActivationLink(String email, String otherStuff) {
    return linkSource.createPageRenderLink(
       "someaction/activateuser", false, email, otherStuff);
}