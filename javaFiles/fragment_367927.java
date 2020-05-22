Iterator<String> iter = personDetails.iterator();
String firstName = null;
if (iter.hasNext())
    firstName = iter.next();
String lastName = null;
if (iter.hasNext())
    lastName = iter.next();
String gender = null;
if (iter.hasNext())
    gender = iter.next();