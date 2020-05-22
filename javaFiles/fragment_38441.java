private static byte[] cmsDecrypt(byte[] message, PrivateKey key) throws
        Exception {
    CMSEnvelopedDataParser ep = new CMSEnvelopedDataParser(message);
    RecipientInformationStore recipients = ep.getRecipientInfos();
    Collection c = recipients.getRecipients();
    Iterator iter = c.iterator();
    RecipientInformation recipient = (RecipientInformation) iter.next();
    return recipient.getContent(key, new BouncyCastleProvider());
}