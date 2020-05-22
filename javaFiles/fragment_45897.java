public class MyImapServer extend ImapServer {
    ...
    protected Properties createSessionProperties() {
        Properties props = super.createSessionProperties()
        props.setProperty("mail.imap.connectiontimeout", 123);
        return props;
    }
}