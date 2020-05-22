final String dbResourcePath = "/embedded.accdb";
@SuppressWarnings("rawtypes")
Class thisClass = JackcessTestMain.class;  // my "main" class
InputStream dbResourceStream = null;
// for running from executable jar 
dbResourceStream = thisClass.getResourceAsStream("/resources" + dbResourcePath);
if (dbResourceStream == null) {
    // for running inside the Eclipse IDE
    dbResourceStream = thisClass.getResourceAsStream(dbResourcePath);
}