CodeDocument codeDocument = new CodeDocument();
// set the values 
session.save( codeDocument );

SaveEvents saveEvents = new SaveEvents();
// set the values
saveEvents.setDocument( codeDocument );
session.save( saveEvents );