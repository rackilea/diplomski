public class DomainMatch {

    public static void main(String[] args) throws Exception {
        MimeMessage msg = new MimeMessage((Session) null);
        msg.addFrom(InternetAddress.parse("foo@bar.org"));
        msg.saveChanges();

        System.out.println(new FromStringTerm("@bar.org").match(msg));
        System.out.println(new FromStringTerm("@spam.org").match(msg));
    }
}