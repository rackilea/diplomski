ImapClient client = new ImapClient();
client.setHost("imap.gmail.com");
client.setPort(993);
client.setUsername("test@gmail.com");
client.setPassword("testPassword");
client.setSecurityOptions(SecurityOptions.SSLAuto);
client.selectFolder(ImapFolderInfo.IN_BOX);

ImapQueryBuilder builder = new ImapQueryBuilder();
// Check for unread messages
builder.hasNoFlags(ImapMessageFlags.isRead());
// set the effective date
builder.getInternalDate().since(new Date("2018/10/05"));
MailQuery query = builder.getQuery();

ImapMessageInfoCollection coll = client.listMessages(query);
for (ImapMessageInfo msgInfo : coll) {
    MailMessage msg = client.fetchMessage(msgInfo.getUniqueId());
    System.out.println("Subject:" + msg.getSubject());
}