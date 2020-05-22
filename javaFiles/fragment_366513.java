String theKey = null;
while(itr.hasNext()) {
  theKey = itr.next();
  if (theKey.startsWith(myString)) {
    return theKey;
  }
}
return null;