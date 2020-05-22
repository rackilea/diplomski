Database db = session.getDatabase("names.nsf");
NotesViewEntryCollection nvec = db.getView("People").getAllEntries();
for(int i=0;i<nvec.getCount();i++){
    doc = nvec.getNthEntry(i).getDocument();
    // get value of doc here
    // recycle
}