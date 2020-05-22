List<String> names = new ArrayList<String>();
List<String> namesDB =  new ArrayList<String>();

// Get some names ??
names.add(Spreadsheets.getString("Name"));

boolean hasCommonNames =  namesDB.retainAll( names );

// The namesDB will only contain the common names.
if( hasCommonNames ) {
    // Do something with the common names
}