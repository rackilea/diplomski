Store store = session.getStore("imap");
store.connect(configc.host, configc.email, configc.pass);
Folder folderInbox = store.getFolder("INBOX");
folderInbox.open(Folder.READ_ONLY);

Message[] onlyBarOrg = folderInbox.search(new FromStringTerm("@bar.org"));