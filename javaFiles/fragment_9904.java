// Create database.
ODatabaseDocumentTx db = new ODatabaseDocumentTx(path);
db.create();

// Create users/roles.
OSecurity sm = db.getMetadata().getSecurity();

restrictedRole = sm.createRole("foobar", OSecurityRole.ALLOW_MODES.DENY_ALL_BUT);
restrictedRole.addRule(ORule.ResourceGeneric.CLASS, TABLE_NAME, ORole.PERMISSION_READ);
restrictedRole.addRule(ORule.ResourceGeneric.DATABASE, TABLE_NAME, ORole.PERMISSION_READ);
restrictedRole.addRule(ORule.ResourceGeneric.CLUSTER, TABLE_NAME, ORole.PERMISSION_READ);
restrictedRole.save();
restrictedRole.reload();

admin = sm.getUser("admin");
user2 = sm.createUser("user2", "user2", "foobar");

// Insert 2 records, one restricted, one is not.
OClass restricted = db.getMetadata().getSchema().getClass("ORestricted");
OClass docClass = db.getMetadata().getSchema().getOrCreateClass(TABLE_NAME, restricted);

ODocument doc1 = new ODocument(docClass);
ODocument doc2 = new ODocument(docClass);

// The restricted record...
doc1.field("name", TABLE_NAME);
doc1.field("Id", 1, OType.INTEGER);
doc1.field("Message", "Hello 1", OType.STRING);
doc1.save();

// The unrestricted record...
doc2.field("name", TABLE_NAME);
doc2.field("Id", 2, OType.INTEGER);
doc2.field("Message", "Hello 2", OType.STRING);
db.getMetadata().getSecurity().allowRole(doc2, OSecurityShared.ALLOW_READ_FIELD, "foobar");
doc2.save();

//
// PRINT RESTRICTED
//
db.close();
db = new ODatabaseDocumentTx(path);
db.open("user2", "user2");

// Prints:
// Hello 2
for (ODocument doc : db.browseClass(TABLE_NAME))
{
  System.out.println(doc.field("Message"));
}

//
// PRINT ADMIN
//
db.close();
db = new ODatabaseDocumentTx(path);
db.open("admin", "admin");

// Prints:
// Hello 1
// Hello 2
for (ODocument doc : db.browseClass(TABLE_NAME))
{
  System.out.println(doc.field("Message"));
}