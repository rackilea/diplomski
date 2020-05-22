Properties props = System.getProperties();
props.setProperty("mail.store.protocol", "imaps");
Session session = Session.getDefaultInstance(props, null);
Store store = session.getStore("imaps");
store.connect("imap.gmail.com", "YOURMAILID@gmail.com", "UR_P@ZZWRD");
System.out.println(store);

Folder[] f = store.getDefaultFolder().list();
for(Folder fd:f)
    System.out.println(">> "+fd.getName());