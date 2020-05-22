Person first = collectionOfPerson.next();
while (collectionOfPerson.hasNext()) {
    Person other = collectionOfPerson.next();
    if (first.comparTo(other) != 0) {
        // Found mismatch, abort
        return false;
    }
}
// Didn't found mismatch
return true;