private static MimeMessage cloneMimeMessage(Session session, MimeMessage src)
    throws MessagingException
{
    if (src instanceof POP3Message)
    {
        return new MimeMessage(session, ((POP3Message)src).top(Integer.MAX_VALUE));
    }
    else if (src instanceof IMAPMessage)
    {
        return new MimeMessage(session, ((IMAPMessage)src).getRawInputStream());
    }
    else
    {
        throw new UnsupportedOperationException();
    }
}